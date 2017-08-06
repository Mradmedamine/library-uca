$(function() {

    var recordContainer = $('#record-container');
    initRecordForm();

    function initRecordForm() {

	var form = $(recordContainer).find('form');
	var formFields = $(form).find('input, select, textArea');
	var selectFields = $(form).find('.selectpicker');

	var panelFooter = $(recordContainer).find('.panel-footer');
	var editBtn = $(panelFooter).find('.btn-edit');
	var saveBtn = $(panelFooter).find('.btn-save');
	var cancelBtn = $(panelFooter).find('.btn-cancel');

	$(editBtn).on('click', function(e) {
	    $(formFields).prop('disabled', false);
	    $(selectFields).selectpicker('refresh');
	    $(this).hide();
	    $(saveBtn).show();
	    $(cancelBtn).show();
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
			updateBtnVisibility();
			toastr["success"]('Element saved successfully');
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
	    $(saveBtn).hide()
	    $(cancelBtn).hide();
	    $(editBtn).show();
	}

	const ADMINISTRATIVE_RECORD = 'ADMINISTRATIVE';

	$(selectFields).filter('[name="type"]').change(function() {
	    var selectedType = $(this).find('option:selected');
	    var bookSelect = $(selectFields).filter('[name="bookId"]').closest('.form-group');
	    
	    if (selectedType.val() == ADMINISTRATIVE_RECORD) {
		$(bookSelect).hide();
	    } else {
		$(bookSelect).show();
	    }
	});
    }

});