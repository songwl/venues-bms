// Plugin: jQuery.dragmove
// Source: github.com/nathco/jQuery.dragmove
// Author: Nathan Rutzky
// Update: 1.0

(function($) {
	
    $.fn.dragmove = function(option) {
    		
    		
        return this.each(function() {
        	  var $this = $(this),
				    data = $this.data('dragmove'),
				    options = typeof option == 'object' && option;
				    
				    if (!data) {
								$this.data('dragmove', (data = new Dragmove(this)));
						}
        	  if (typeof option == 'string' && typeof data[option] == 'function') {
								data[option].apply(data);
						}
    				return ;         
        });
            
    };
    
    var Dragmove = function(element){
    		var that = this;
    		this.disabled=false;
    		
    		var $document = $(document),
            $this = $(element),
            active,
            startX,
            startY;
        
        $this.on('mousedown touchstart', function(e) {
        
        		if(DragmoveGlobal.disabled){
        			return false;	
        		}
        		
            active = true;
            startX = e.originalEvent.pageX - $this.offset().left;
            startY = e.originalEvent.pageY - $this.offset().top;	
            
            if ('mousedown' == e.type)
                
                click = $this;
                                
            if ('touchstart' == e.type)
            
                touch = $this;
                                
            if (window.mozInnerScreenX == null)
            
                return false;	
        });
        
        $document.on('mousemove touchmove', function(e) {
            
            if ('mousemove' == e.type && active)
            
                click.offset({ 
                
                    left: e.originalEvent.pageX - startX,
                    top: e.originalEvent.pageY - startY 
                
                });
            
            if ('touchmove' == e.type && active)
            
                touch.offset({
                
                    left: e.originalEvent.pageX - startX,
                    top: e.originalEvent.pageY - startY
                    
                });
            
        }).on('mouseup touchend', function() {
            
            active = false;
            
        });
    };
    
    Dragmove.prototype = {
    		constructor: Dragmove,
    		
    		disable: function(){
    			DragmoveGlobal.disabled = true;
    		},
    		
    		enable: function(){
    			DragmoveGlobal.disabled = false;
    		}
    };
    
    var DragmoveGlobal = {
    		disabled:false
    };

})(jQuery);