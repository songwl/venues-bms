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
	initPicker();
	initTree();
	
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
	
	$(".body-section form[modal]").submit(function(){
		var $this = $(this);
		var $modal = $this.closest(".modal");
		var modalId = $modal.attr("id");
		formSubmit(this,function(){
			$("#"+modalId).modal("hide");
		});
		return false;
	});
	
	$(".body-section form[page] a[page]").each(function(){
		$(this).click(function(){
			toPage($(this));
			return false;
		});
	});
	
	$(".body-section a[target!='_blank']").click(function(){
		var $this = $(this);
		var url = $this.attr("href");
		loadMainBody(url);
		return false;
	});
	
	$(".body-section a[ajaxToDo]").click(function(){
		var $this = $(this);
		var url = $this.attr("href");
		var callurl = $this.attr("callurl");
		ajaxTodo(url,callurl);
		return false;
	});
	
	initCheckToDo();
}

//初始化时间控件
function initPicker(){
	$('.body-section .date-picker').datepicker({
		format: 'yyyy-mm-dd',
		language: 'cn',
		autoclose : true,
        todayHighlight : false,
        clearBtn : true
	});
	
	$('.body-section .datetime-picker').datetimepicker({
		format: 'yyyy-mm-dd hh:ii:dd',
		language: 'cn',
		autoclose: true,
		todayHighlight : false,
		clearBtn : true
	});
	
}

//初始化tree
function initTree(){
	var DataSourceTree = function () {
	};

	DataSourceTree.prototype = {
	    data: function (options, callback) {
	        var data = $.extend(true, []);
	        callback({ data: data });
	    }
	};
	
	$('.body-section .func-tree').each(function(i,ele){
		$(ele).tree({
			dataSource: new DataSourceTree(),
			selectable: false
		});
	});
	
	$(".body-section .func-tree input[type='checkbox']").click(function(event){
		var $this = $(this);
		var checked = $this.prop("checked");
		var selectType = $this.attr("selectType");
		var $folder = $this.closest(".tree-folder");
		if(selectType=="folder"){
			$folder.find(".tree-folder-content .tree-item input[type=checkbox]").prop("checked",checked);
			event.stopPropagation(); 
		}else{
			if($folder.length>0){
				if(checked || $folder.find(".tree-item input[type=checkbox]:checked").length==0){
					$folder.find(".tree-folder-header input[type=checkbox]").prop("checked",checked);
				}
			}
		}
	});
	
}

//初始化check
function initCheckToDo(){
	$('.body-section input[type="checkbox"][name="checkAll"]').click(function(){
		var checked = $(this).prop("checked");
		var rel = $(this).attr("rel");
		if(rel){
			$("input[type='checkbox'][name='"+rel+"']").prop("checked",checked);
		}
	});
	
	$('.body-section a[checkToDo]').click(function(){
		var rel = $(this).attr("rel");
		if(rel){
			var ids = "";
			$("input[type='checkbox'][name='"+rel+"']:checked").each(function(i,ele){
				if(i>0){
					ids += ",";
				}
				ids += $(ele).val();
			});
			if(ids==""){
				alertMsg.error("请至少选择一项");
			}else{
				var url = $(this).attr("href");
				var param = rel+"="+ids;
				if(url.indexOf("?")){
					url += "?"+param;
				}else{
					url += "&"+param;
				}
				var callurl = $(this).attr("callurl");
				ajaxTodo(url,callurl);
			}
			
		}
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


function formSubmit(form,success){
	var $form = $(form);
	var valid = $form.valid();
	if(valid){
		var url = $form.attr("action");
		var data = $form.serialize();
		$.post(url, data,function(rs){
			if(rs["success"]==true){
				if(success){
					success();
				}
				alertMsg.correct(rs["message"]);
				if($form.attr("callurl")){
					var callurl = $form.attr("callurl");
					loadMainBody(callurl);
				}
			}else{
				alertMsg.error(rs["message"]);
			}
        }, "json");
	}
	return false;
}

function ajaxTodo(url,callurl){
	$.ajax({
		  type: "GET",
		  url: url,
		  dataType: "JSON",
		  success: function(rs){
			  if(rs["success"]==true){
				  alertMsg.correct(rs["message"]);
				  if(!callurl){
					  loadMainBody($(".body-section").data("url"),$(".body-section").data("data"));
				  }else if(callurl && callurl=="none"){
					  //alertMsg.correct(rs["message"]);
				  }else{
					  loadMainBody(callurl);
				  }
				  
			  }else{
				  alertMsg.error(rs["message"]);
			  }
		  }
	});
}

$.fn.datetimepicker.dates["cn"] = {
	days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
    daysShort: ["日", "一", "二", "三", "四", "五", "六", "七"],
    daysMin: ["日", "一", "二", "三", "四", "五", "六", "七"],
    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    meridiem: ["上午", "下午"],
    today: "今天",
    clear: "清除"
};

$.fn.datepicker.dates["cn"] = {
	days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
    daysShort: ["日", "一", "二", "三", "四", "五", "六", "七"],
    daysMin: ["日", "一", "二", "三", "四", "五", "六", "七"],
    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    meridiem: ["上午", "下午"],
    today: "今天",
    clear: "清除"
};
