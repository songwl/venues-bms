/**
 * @author 前台弹出消息窗体
 */

var alertMsg = {
	_boxId: "alertMsgBox", 
	_closeTimer: null,
	
	_msg: {
		title:{error:"错误", info:"提示", warn:"提示", correct:"成功", confirm:"确认提示"},
		style:{error:"danger", info:"info", warn:"warning", correct:"success", confirm:"primary"},
		butMsg:{ok:"确定", yes:"是", no:"否", cancel:"取消"}
	},

	_types: {error:"error", info:"info", warn:"warn", correct:"correct", confirm:"confirm"},

	_getTitle: function(key){
		return this._msg.title[key];
	}, 
	_getStyle: function(key){
		return this._msg.style[key];
	}, 
	
	_alert: function(type, msg, options) {
		$("#"+this._boxId).remove();
		
		var op = {
				title: this._getTitle(type),
				style: this._getStyle(type),
				width: 350 , 
				height: 200 , 
				modal: true, 
				buttons: [ {text: this._msg.butMsg.ok, click:function(){alertMsg.close();}} ]
			};
		$.extend(op, options);
		
		//_box = $("<div id=\""+this._boxId+"\">"+msg+"</div>");
		//$(_box).dialog(op);
		this._makeBox(op,msg);
		$("#"+this._boxId).modal("show");
		
		if (this._closeTimer) {
			clearTimeout(this._closeTimer);
			this._closeTimer = null;
		}
		
		if (this._types.info == type || this._types.correct == type){
			this._closeTimer = setTimeout(function(){alertMsg.close();}, 1500);
		}
	},
	
	_makeBox: function(op,msg){
		var _box = '<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="'+this._boxId+'" class="modal fade">'
            		+'<div class="modal-dialog">'
            			+'<div class="modal-content">'
            				+'<div class="modal-header">'
            					+'<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>'
            						+'<h4 class="modal-title">'+op.title+'</h4>'
            				+'</div>'
            				+'<div class="modal-body">'
            					+'<p class="text-'+op.style+'">'+ msg +'</p>'
            				+'</div>'
            				+'<div class="modal-footer">'
            				+'</div>'
            			+'</div>'
            		+'</div>'
            	+'</div>';
		$("body").append(_box);
		var _$box = $("#"+this._boxId);
		//按钮事件
		for(var i in op.buttons){
			var button = op.buttons[i];
			//var btnStyle = button.style? button.style : op.style;
			var $button = $('<button type="button" class="btn btn-'+op.style+'">'+button.text+'</button>');
			_$box.find(".modal-footer").append($button);
			$button.bind("click",function(){
				var event = button.click;
				if (!$.isFunction(event)) event = eval('(' + event + ')');
				event();
			});
		}
	},
	
	error: function(msg, options) { 		
		this._alert(this._types.error, msg, options);
	},
	info: function(msg, options) {
		this._alert(this._types.info, msg, options);
	},
	warn: function(msg, options) {
		this._alert(this._types.warn, msg, options);
	},
	correct: function(msg, options) {
		var op = {okName: this._msg.butMsg.ok, okCall:null};
		$.extend(op, options);
		op.buttons = [
			{ text:op.okName, click:op.okCall }
		];
		this._alert(this._types.correct, msg, op);
	},
	
	/**
	 * 
	 * @param {Object} msg
	 * @param {Object} options
	 */
	confirm: function(msg, options) {
		var op = {okName: this._msg.butMsg.ok, okCall:null, cancelName: this._msg.butMsg.cancel, cancelCall:function(){$("#"+this._boxId).remove();}};
		op.buttons = [
		  			{ text:op.okName, click:options.okCall },
		  			{ text:op.cancelName, click:op.cancelCall||function(){alertMsg.close();} }
		  		];
		$.extend(op, options);
		this._alert(this._types.confirm, msg, op);
	},
	
	close: function(){
		$("#"+this._boxId).modal("hide");
	}
	
};

