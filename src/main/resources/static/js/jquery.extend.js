$.fn.extend({

    hide : function() {
	return this.addClass('hidden');
    },
    show : function() {
	return this.removeClass('hidden');
    },

    serializeObject : function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
	    if (o[this.name] !== undefined) {
		if (!o[this.name].push) {
		    o[this.name] = [ o[this.name] ];
		}
		o[this.name].push(this.value || '');
	    } else {
		o[this.name] = this.value || '';
	    }
	});
	return o;
    }
});