$(function() {

    var recordFormContainer = $('#record-form-container');
    initRecordForm();

    function initRecordForm() {

	var form = $(recordFormContainer).find('form');
	var formFields = $(form).find('input, select, textArea');
	var selectFields = $(form).find('.selectpicker');

	var panelFooter = $(recordFormContainer).find('.panel-footer');
	var editBtn = $(panelFooter).find('.btn-edit');
	var saveBtn = $(panelFooter).find('.btn-save');
	var cancelBtn = $(panelFooter).find('.btn-cancel');
	var backBtn = $(panelFooter).find('.btn-back');

	$(backBtn).on('click', function(event) {
	    window.location.href = "/records";
	});

	$(editBtn).on('click', function(e) {
	    $(formFields).prop('disabled', false);
	    $(selectFields).selectpicker('refresh');
	    $(panelFooter).removeClass('readonly');
	});

	$(saveBtn).on('click', function(e) {
	    if ($(form).valid()) {
		var method = $(form).attr('method');
		var data = $(form).serializeObject();

		$.ajax({
		    type : 'POST',
		    url : recordsUrl,
		    data : JSON.stringify(data),
		    contentType : 'application/json',
		    success : function(data) {
			$(form).find('#recordId').val(data);
			updateBtnVisibility();
			toastr["success"](message.common.savingSuccessMessage);
			$('#toast-container .toast-success').show();
		    }
		});
	    }
	});

	$(cancelBtn).on('click', function(e) {
	    updateBtnVisibility();
	});

	function updateBtnVisibility() {
	    $(formFields).prop('disabled', true);
	    $(selectFields).selectpicker('refresh');
	    $(panelFooter).addClass('readonly');
	}

	const
	ADMINISTRATIVE_RECORD = 'ADMINISTRATIVE';

	$(selectFields).filter('[name="type"]').change(
		function() {
		    var selectedType = $(this).find('option:selected');
		    var bookSelect = $(selectFields).filter('[name="bookId"]')
			    .closest('.form-group');

		    if (selectedType.val() == ADMINISTRATIVE_RECORD) {
			$(bookSelect).hide();
		    } else {
			$(bookSelect).show();
		    }
		});
    }

});