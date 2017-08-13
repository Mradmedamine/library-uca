$(function() {

	var authorFormContainer = $('#author-form-container');
	var panelFooter = $(authorFormContainer).find('.panel-footer');
	
	var backBtn = $(panelFooter).find('.btn-back');
	
	$(backBtn).on('click', function(event) {
		window.location.href = "/authors";
	});
	

});