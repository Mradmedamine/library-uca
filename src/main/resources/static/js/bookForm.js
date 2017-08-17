$(function() {

    var bookContainer = $('#book-form-container');
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
	var backBtn = $(panelFooter).find('.btn-back');
	var cancelBtn = $(panelFooter).find('.btn-cancel');

	$(backBtn).on('click', function(event) {
	    window.location.href = "/books";
	});

	$(editBtn).on('click', function(event) {
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
		    url : '/books',
		    data : JSON.stringify(data),
		    contentType : 'application/json',
		    success : function(data) {
			$(form).find('#bookId').val(data);
			updateBtnVisibility();
			toastr["success"](savingSuccessMessage);
			$('#toast-container .toast-success').show();
		    }
		});
	    }
	});

	$(cancelBtn).on('click', function(event) {
	    updateBtnVisibility();
	});

	function updateBtnVisibility() {
	    $(formFields).prop('disabled', true);
	    $(selectFields).selectpicker('refresh');
	    $(panelFooter).addClass('readonly');
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

	var newBtn = $(bookContainer).find('.dt-buttons button');
	var modal = $('#page-wrapper').find('#editionModal');
	var editionForm = $(modal).find('form');
	var closeBtn = $(modal).find('.close');
	var backBtn = $(modal).find('.panel-footer .btn-back');
	var saveBtn = $(modal).find('.panel-footer .btn-save');

	$(newBtn).on('click', function() {
	    $(modal).show();
	});

	$(closeBtn).on('click', function() {
	    $(modal).hide();
	});

	$(backBtn).on('click', function() {
	    $(modal).hide();
	});

	$(saveBtn).on('click', function() {
	    if ($(editionForm).valid()) {
		var data = $(editionForm).serializeObject();
		$.ajax({
		    type : 'POST',
		    url : bookEditionsUrl,
		    data : JSON.stringify(data),
		    contentType : 'application/json',
		    success : function(data) {
			// add row
			$(modal).hide();
			toastr["success"](savingSuccessMessage);
			$('#toast-container .toast-success').show();
		    }
		});
	    }
	});

	$(window).on('click', function(event) {
	    if (event.target == modal) {
		$(modal).hide();
	    }
	});
    }

});