$(function() {  
	$.fn.freedrag = function(option) {
    	
        return this.each(function() {
			$(this).dragmove(); 
			$(this).resizable({
				handles : "n,e,se,all",
					helper : false,
					helperStyle : {
						"border" : "1px solid #888"
					},
					//maxHeight : 600,
					//maxWidth : 600,
					minHeight : 10,
					minWidth : 10,
					onStartResize : function() {
						$(this).dragmove("disable");
					},
					onResize : function() {
					},
					onStopResize : function() {
						$(this).dragmove("enable");
					}
				
			});       
        });
            
    };
		

});