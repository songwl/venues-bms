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
	
	$(".body-section form[edit]").submit(function(){
		alert(111);
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
		$.post(url, data,function(rs){
			if(rs["success"]==true){
				if($form.attr("callurl")){
					var callurl = $form.attr("callurl");
					loadMainBody(callurl);
				}
			}else{
				var $alert = $("<div class='alert alert-danger' style='display:none;'>"+(rs["message"])+"</div>"); 
				$form.after($alert);
				$alert.fadeIn("fast",function(){
					$alert.fadeOut("slow");
				});
			}
        }, "json");
	}
	return false;
}