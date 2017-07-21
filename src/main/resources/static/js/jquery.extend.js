$.fn.extend({

    isActive : function() {
	return this.hasClass('active');
    },
    activate : function() {
	this.addClass('active');
    },
    deactivate : function() {
	this.removeClass('active');
    }

});