$(function() {

    var fileFormContainer = $('#file-form-container');
    var actionsTable = $('#actions-table');
    var actionsDataTable;

    initFileForm();
    initActionsDataTables();
    initActionModal();

    function initFileForm() {
	// Fields
	var form = $(fileFormContainer).find('form');
	var formFields = $(form).find('input, select, textArea');
	var selectFields = $(form).find('.selectpicker');
	// Buttons
	var panelFooter = $(fileFormContainer).find('.panel-footer');
	var editBtn = $(panelFooter).find('.btn-edit');
	var saveBtn = $(panelFooter).find('.btn-save');
	var cancelBtn = $(panelFooter).find('.btn-cancel');
	var backBtn = $(panelFooter).find('.btn-back');

	$(backBtn).on('click', function(event) {
	    window.location.href = "/files";
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
		    url : filesUrl,
		    data : JSON.stringify(data),
		    contentType : 'application/json',
		    success : function(data) {
			$(form).find('#fileId').val(data);
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

    function initActionsDataTables() {
	if (actionsTable.length) {
	    actionsDataTable = $(actionsTable).DataTable({
		language : dataTablesMessages,
		dom : 'Brt',
		buttons : [ dataTablesPdfBtnLabel ]
	    });
	}
	var dtBtns = $(fileFormContainer).find('.dt-buttons');
	styleDtPdfButton(dtBtns);
	$(dtBtns).prepend(dataTablesNewBtnHtml);
	initActionsTable();
    }

    function initActionsTable() {
	$(actionsTable).on('click', '.action', function(e) {
	    if (!$(e.target).hasClass('action-lock')) {
		e.preventDefault();
		var actionId = $(this).find('td:first').text();
		$.ajax({
		    type : 'GET',
		    url : '/files/actions/' + actionId,
		    success : function(data) {
			$('#actionModal').replaceWith(data);
			initActionModal();
			$('#actionModal').show();
		    }
		});
	    }
	});
    }

    function initActionModal() {

	var modal = $('#page-wrapper').find('#actionModal');
	var actionForm = $(modal).find('form');
	var closeBtn = $(modal).find('.close');
	var backBtn = $(modal).find('.panel-footer .btn-back');
	var saveBtn = $(modal).find('.panel-footer .btn-save');
	var newBtn = $(fileFormContainer).find('.dt-buttons button');

	var fileInput = $(actionForm).find(':file');
	var fileName = $(fileInput).attr('data-placeholder');
	$(fileInput).filestyle({
	    placeholder : fileName
	});

	$(newBtn).on('click', function() {
	    $(modal).show();
	});

	$(closeBtn).on('click', function() {
	    $(actionForm).reset();
	    $(modal).hide();
	});

	$(backBtn).on('click', function() {
	    $(actionForm).reset();
	    $(modal).hide();
	});

	$(saveBtn).on('click', function() {
	    $(actionForm).submit();
	});

	$(actionForm).submit(function() {
	    if ($(actionForm).valid()) {
		var file = $(actionForm).find('#physicalFile').prop('files')[0];
		if (file.size > 2048576) {
		    toastr["error"](message.common.fileSizeError);
		    $('#toast-container .toast-error').show();
		    return false;
		}
		var formObject = $(this).serializeObject();
		var formData = new FormData();
		formData.append("physicalFile", file);
		formData.append('fileAction', createFileActionJSON(formObject));

		$.ajax({
		    type : 'POST',
		    url : fileActionsUrl,
		    data : formData,
		    async : false,
		    cache : false,
		    contentType : false,
		    processData : false,
		    success : function(result) {
			$(modal).hide();
			toastr['success'](message.common.savingSuccessMessage);
			$('#toast-container .toast-success').show();
			timer = setTimeout(function() {
			    location.reload();
			}, 1000);
		    }
		});
	    }
	    return false;
	});

	function createFileActionJSON(formObject) {
	    var data = {
		'id' : formObject['id'],
		'date' : formObject['date'],
		'description' : formObject['description']
	    };
	    return new Blob([ JSON.stringify(data) ], {
		type : "application/json"
	    });
	}

	$(window).on('click', function(event) {
	    if (event.target == modal) {
		$(modal).hide();
	    }
	});
    }

});