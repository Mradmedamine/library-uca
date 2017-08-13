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
		var cancelBtn = $(panelFooter).find('.btn-cancel');
		var backBtn = $(panelFooter).find('.btn-back');
		
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

		var modal = $('#page-wrapper').find('#editionModal');
		var newBtn = $(bookContainer).find('.dt-buttons button');
		var closeBtn = $(modal).find('.close');
		var backBtn = $(modal).find('.panel-footer .btn-back');
		
		$(newBtn).on('click', function() {
			$(modal).show();
		});
		
		$(closeBtn).on('click', function() {
			$(modal).hide();
		});
		
		$(backBtn).on('click', function() {
			$(modal).hide();
		});
		
		$(window).on('click', function(event) {
			if (event.target == modal) {
				$(modal).hide();
			}
		});
	}

});