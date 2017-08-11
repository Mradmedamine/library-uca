$(function() {

    var bookContainer = $('#book-form-container');
    var editor;
    initBookForm();
    initEditionsDataTables();
    initEditionModal();
    
    function initBookForm() {

	var form = $(bookContainer).find('form');
	var formFields = $(form).find('input, select, textArea');
	var selectFields = $(form).find('.selectpicker');

	var panelFooter = $(bookContainer).find('.panel-footer');
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
			toastr["success"](savingSuccessMessage);
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
    }

    function initEditionsDataTables() {
	var editionsDataTable = $('#editions-table');
	if (editionsDataTable.length) {
	    $(editionsDataTable).DataTable({
		language : {
		    "emptyTable" : emptySearchResultMessage
		},
		dom : '<"dt-buttons">frtip'
	    });
	}
	var editionBtn = '<button class="btn btn-primary btn-block" type="button"><i class="fa fa-plus fa-fw"></i>New</button>';
	$(bookContainer).find('div.dt-buttons').html(editionBtn);
    }

    function initEditionModal() {

	var modal = $(bookContainer).find('#newEditionModal');
	var btn = $(bookContainer).find('.dt-buttons button');
	var span = $(bookContainer).find('.close');

	$(btn).on('click', function() {
	    $(modal).show();
	});

	// When the user clicks on <span> (x), close the modal
	$(span).on('click', function() {
	    $(modal).hide();
	});

	// When the user clicks anywhere outside of the modal, close it
//	$(window).on('click', function(event) {
//	    if (event.target == modal) {
//		$(modal).hide();
//	    }
//	});
    }

});