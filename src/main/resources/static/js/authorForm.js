$(function() {

	var bookContainer = $('#author-form-container');
	
	var backBtn = $(panelFooter).find('.btn-back');
	
	$(backBtn).on('click', function(event) {
		window.location.href = "/authors";
	});
	

});