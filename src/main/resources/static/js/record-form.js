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
	    var method = $(form).attr('method');
	    var data = $(form).serializeObject();

	    $.ajax({
		type : 'POST',
		url : recordsUrl,
		data : JSON.stringify(data),
		contentType : 'application/json',
		success : function(data) {
		    $(formFields).prop('disabled', true);
		    $(selectFields).selectpicker('refresh');
		    $(this).hide();
		    $(cancelBtn).hide();
		    $(editBtn).show();
		    console.log('success');
		}
	    });
	});

	$(cancelBtn).on('click', function(e) {
	    $(formFields).prop('disabled', true);
	    $(selectFields).selectpicker('refresh');
	    $(this).hide();
	    $(saveBtn).hide();
	    $(editBtn).show();
	});
    }

});