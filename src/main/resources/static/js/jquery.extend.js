$.fn.extend({

    hide: function() {
	return this.addClass('hidden');
    },
    show : function() {
	return this.removeClass('hidden');
    }

});