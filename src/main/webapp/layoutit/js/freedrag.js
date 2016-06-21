// Plugin: jQuery.dragmove
// Source: github.com/nathco/jQuery.dragmove
// Author: Nathan Rutzky
// Update: 1.0

(function($) {
	
    $.fn.freedrag = function(option) {
    		    		
        return this.each(function() {
        	  $(this).data("left",$(this).css("left"));
        	  $(this).data("top",$(this).css("top"));
        	  if(!$(this).hasClass("freedrag")){
        	  	$(this).addClass("freedrag");	
        	  }else{
        	  	$(this).find(".ui-resizable-handle").remove();
        	  }
        	  
        	  //$(this).resizable();
			    	$(this).resizable({
			    		alsoResize: 'parent',
			    		autoHide: true,
			    		
			    		//handles : "n,e",
							//helper : true,
							//helperStyle : {
								//"border" : "1px solid #888"
							//},
							//maxHeight : 500,
							//maxWidth : 500,
							//minHeight : 10,
							//minWidth : 10,
							create: function(event,ui) {
								$(this).resizable( "option", "maxWidth" ,$(this).parent().width());
								
							},
							start : function(event, ui) {
								var curleft, curtop;
								
								curleft = $(this).data("left");
								curtop = $(this).data("top");
															
								ui.position = { left: curleft, top: curtop };
					
								ui.originalPosition = { left: curleft, top: curtop };
								
								$(this).css("left",curleft);
								$(this).css("top",curtop);
								
								$(this).draggable("disable");
							},
							resize : function(event, ui) {
							},
							stop: function(event, ui) {
								$(this).draggable("enable");
							}
			    		
			    	}); 
			    	
			    	$(this).draggable({
        	  	containment: 'parent',
        	  	handle: ".drag",
        	  	start: function(event, ui) {
        				
      				},
      				drag: function(event, ui) {
        			
      				},
      				stop: function(event, ui) {
        				$(this).data("left",$(this).css("left"));
        	  		$(this).data("top",$(this).css("top"));
      				}
        	  }); 
    				return ;         
        });
            
    };


})(jQuery);