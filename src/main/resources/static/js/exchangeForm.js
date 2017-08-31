$(function() {
	
	var urlExchanges = '/exchanges';

	var exchangeFormContainer = $('#exchange-form-container');
	var panelFooter = $(exchangeFormContainer).find('.panel-footer');

	var form = $(exchangeFormContainer).find('form');
	var formFields = $(form).find('input');

	var backBtn = $(panelFooter).find('.btn-back');
	var editBtn = $(panelFooter).find('.btn-edit');
	var cancelBtn = $(panelFooter).find('.btn-cancel');
	var saveBtn = $(panelFooter).find('.btn-save');

	$(backBtn).on('click', function(event) {
		window.location.href = urlExchanges;
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
				url : urlExchanges,
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(data) {
				 	$(form).find('#exchangeId').val(data);
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