$(function() {
	
	var urlAuthors = '/authors';

	var authorFormContainer = $('#author-form-container');
	var panelFooter = $(authorFormContainer).find('.panel-footer');

	var form = $(authorFormContainer).find('form');
	var formFields = $(form).find('input');

	var backBtn = $(panelFooter).find('.btn-back');
	var editBtn = $(panelFooter).find('.btn-edit');
	var cancelBtn = $(panelFooter).find('.btn-cancel');
	var saveBtn = $(panelFooter).find('.btn-save');

	$(backBtn).on('click', function(event) {
		window.location.href = urlAuthors;
	});

	$(editBtn).on('click', function(event) {
		$(formFields).prop('disabled', false);
		$(panelFooter).removeClass('readonly');
	});

	$(cancelBtn).on('click', function(e) {
		updateBtnVisibility();
	});
	
	$(saveBtn).on('click', function(e) {
		if ($(form).valid()) {
			var method = $(form).attr('method');
			var data = $(form).serializeObject();

			$.ajax({
				type : 'POST',
				url : urlAuthors,
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(data) {
				 	$(form).find('#authorId').val(data);
					updateBtnVisibility();
					toastr["success"](message.common.savingSuccessMessage);
					$('#toast-container .toast-success').show();
				}
			});
		}
	});

	function updateBtnVisibility() {
		$(formFields).prop('disabled', true);
		$(panelFooter).addClass('readonly');
	}

});