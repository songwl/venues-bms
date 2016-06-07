 $(".s_include").each(function(i,ele){
				var url = $(ele).attr("url");
				$.ajax({
				   url: url,
				   type: "GET",
				   dataType: "html",
				   async: false,
				   success: function(html){
				   		$(ele).html(html);
				   }
				 });
		});
		 
		
		 
 