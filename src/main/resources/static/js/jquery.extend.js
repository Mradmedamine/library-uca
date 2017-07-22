$.fn.extend({

    isActive : function() {
	return this.hasClass('active');
    },
    activate : function() {
	this.addClass('active');
    },
    deactivate : function() {
	this.removeClass('active');
    },
    collapse : function() {
	this.addClass('collapsed');
    },
    uncollapse : function() {
	this.removeClass('collapsed');
    }

});