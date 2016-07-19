/******************
 * 文件上传工具.
 * 引用前先引入 ajaxupload.js
 * 
 * 使用方式 <button id="uploadFile" type="button" fileTypeExts="jpg|png|jpeg|gif" serviceType="basecode">上传</button>
 * <script type="text/javascript">
 * 		$(document).ready(function(){
 * 			MaidouAjaxUpload($("#uploadFile"),callback);
 * 		});
 * 
 * 		function callback(comFile){
 * 			//callback do something...
 * 		}
 * </script>
 */
(function() {
	/**
	 * @param $ele	被绑定上传功能的元素
	 * ## fileTypeExts 在元素上定义好过滤的文件类型
	 * ## serviceType 文件对应的服务类型  默认类型 basecode
	 * @param callback 回调方法 传入comFile对象
	 */
	BmsAjaxUpload = function($ele,callback){
		new AjaxUpload($ele,{
			action:'/venues/file/upload',
			data: {"serviceType":""},
			autoSubmit:true,
			name:'vfile',
			onSubmit:function(file,ext){
				if(ext) {
					ext = ext.toLowerCase();
				}
				if (ext && /^(jpg|png|flv)$/.test(ext)){
					
				}else{
					alert("文件格式错误。目前仅支持jpg|png|flv");
					return false;
				}
				return true;
			},
			onComplete:function(file,dt){
				var result=eval("("+dt+")");
				if(result.error==0){ //成功
					if (!$.isFunction(callback)){ 
						callback = eval('(' + callback + ')');
					}
					if($.isFunction(callback)){
						callback(result["attach"]);
					}
				}else{
					alert(result.message);
				}
			}
		});
		
	};
	
	/*MaidouAjaxImageUpload = function($ele,callback){
		new AjaxUpload($ele,{
			action:'/venues/file/upload',
			autoSubmit:true,
			name:'imgFile',
			onSubmit:function(file,ext){
				if(ext) {
					ext = ext.toLowerCase();
				}
				var fileType = $ele.attr("fileType");
				if (!fileType || $.trim(fileType)==""){
					fileType = "IMAGE";
				}
				
				if (fileType=="IMAGE" && ext && /^(jpg|png|jpeg|gif)$/.test(ext)){
					var data={};
					var $form=$("#uploadForm");
					data["productId"]=current_product_id;
					data["type"]=$form.find("select[name=type] :selected").val();
					data["imgname"]=$form.find("input[name=imgname]").val();
					this.setData(data);
					this.disable();
					return true;
					
				} else if (fileType=="AUDIO" && ext && /^(wav|mp3|wma|ogg|ape|acc)$/.test(ext)){
					
				}else{
					alert("文件格式错误");
					return false;
				}
				return true;
			},
			onComplete:function(file,dt){
				var data=eval("("+dt+")");
				if(data.error==0){ //成功
					if (!$.isFunction(callback)){ 
						callback = eval('(' + callback + ')');
					}
					if($.isFunction(callback)){
						callback(data["url"],file);
					}
				}else{
					alert(data.message);
				}
			}
		});
		
	};*/
})();