$(function(){
	$(".nav a[url]").bind("click",function(){
		var $this = $(this);
		var url = $this.attr("url");
		loadMainBody(url);
		$(".nav li.active").removeClass("active");
		$this.parent().addClass("active");
		return false;
	});
	
});

function loadMainBody(url,data){
	var type = "POST";
	if(!data){
		data = {};
		type = "GET";
	}
	$.ajax({
	   type: type,
	   url: url,
	   data: data,
	   dataType: "html",
	   success: function(html){
		   $(".body-section").html(html);
		   $(".body-section").data("url",url);
		   $(".body-section").data("data",data);
		   initMainBody();
	   }
	});
	
}

function initMainBody(){
	$(".body-section form[query]").submit(function(){
		var $form = $(this);
		var url = $form.attr("action");
		var data = $form.serialize();
		loadMainBody(url,data);
		return false;
	});
	
	$(".body-section form[valid]").submit(function(){
		formSubmit(this);
		return false;
	});
	
	$(".body-section form[page] a[page]").each(function(){
		$(this).click(function(){
			toPage($(this));
			return false;
		});
	});
	
	$(".body-section a[target]").click(function(){
		var $this = $(this);
		var url = $this.attr("href");
		loadMainBody(url);
		return false;
	});
	
	$(".body-section a[ajaxToDo]").click(function(){
		var $this = $(this);
		var url = $this.attr("href");
		$.ajax({
			  type: "GET",
			  url: url,
			  dataType: "JSON",
			  success: function(rs){
				  if(rs["success"]==true){
					  var callurl = $this.attr("callurl");
					  if(!callurl){
						  loadMainBody($(".body-section").data("url"),$(".body-section").data("data"));
					  }else if(callurl && callurl=="none"){
						  alertMsg.correct(rs["message"]);
					  }else{
						  loadMainBody(callurl);
					  }
					  
				  }else{
					  alertMsg.error(rs["message"]);
				  }
			  }
		});
		
		return false;
	});
}

function toPage($this){
	var $form = $this.parents("form");

	var page = $this.attr("page");
	var url = $form.attr("action");
	url+=page;
	loadMainBody(url);
}


function formSubmit(form){
	var $form = $(form);
	var valid = $form.valid();
	if(valid){
		var url = $form.attr("action");
		var data = $form.serialize();
		$.post(url, data,function(rs){
			if(rs["success"]==true){
				if($form.find("input[name=callurl]").length>0){
					var callurl = $form.find("input[name=callurl]").val();
					loadMainBody(callurl);
				}
			}else{
				alertMsg.error(rs["message"]);
			}
        }, "json");
	}
	return false;
}