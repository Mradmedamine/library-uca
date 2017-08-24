$(function() {

    var fileFormContainer = $('#file-form-container');
    var actionsTable = $('#actions-table');
    var actionsDataTable;
    
    initFileForm();
    initActionsDataTables();
    initActionModal();
    
    function initFileForm() {
	//Fields
	var form = $(fileFormContainer).find('form');
	var formFields = $(form).find('input, select, textArea');
	var selectFields = $(form).find('.selectpicker');
	//Buttons
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
    
    
    
    function initActionsDataTables() {
	if (actionsTable.length) {
	    actionsDataTable = $(actionsTable).DataTable({
		language : dataTablesMessages,
		dom : '<"dt-buttons">frt'
	    });
	}
	var newBtnHtml = '<button class="btn btn-primary btn-block" type="button">'
	    		+'<i class="fa fa-plus fa-fw"></i>'+  message.common.newLabel + '</button>';
	var dtBtns = $(fileFormContainer).find('.dt-buttons');
	$(dtBtns).html(newBtnHtml);

	$(actionsTable).find('.action').each(function() {
	    $(this).on('click', function(e) {
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
	    });
	});

    }

    function initActionModal() {

	var modal = $('#page-wrapper').find('#actionModal');
	var actionForm = $(modal).find('form');
	var closeBtn = $(modal).find('.close');
	var backBtn = $(modal).find('.panel-footer .btn-back');
	var saveBtn = $(modal).find('.panel-footer .btn-save');
	var newBtn = $(fileFormContainer).find('.dt-buttons button');

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
	    
	    if ($(actionForm).valid()) {
	        var data = $(actionForm).serializeObject();
	        $.ajax({
	            type : 'POST',
	            url : fileActionsUrl,
	            data : JSON.stringify(data),
	            contentType : 'application/json',
	            success : function(result) {
	        	if (data['id'].length) {
	        	    updateRow(data, result);
	        	} else {
	        	    addRow(data, result);
	        	}
		        $(modal).hide();
		        toastr["success"](message.common.savingSuccessMessage);
		        $('#toast-container .toast-success').show();
	            }
	        });
	    }

	    function addRow(data, id) {
	        // add row
	        var rowNode = actionsDataTable.row.add(
	                [   id, 
	                    data['description'], 
	                    data['date']
	                ]).draw(false).node();
	        $(rowNode).find('td').first().addClass('hidden');
	    }
	    
	    function updateRow(data, id) {
		var row = $(actionsTable).find('tr[data-id="' + id + '"]');
		actionsDataTable.row(row).data(
			[   id, 
	                    data['description'], 
	                    data['date'] 
	                ]).draw();
	    }
        });

	$(window).on('click', function(event) {
	    if (event.target == modal) {
		$(modal).hide();
	    }
	});
    }

});