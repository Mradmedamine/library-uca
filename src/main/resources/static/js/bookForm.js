$(function() {

    var bookContainer = $('#book-container');
    var editor; 
    initBookForm();
    initEditionsDataTables();
    
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
		"language" : {
		    "emptyTable" : emptySearchResultMessage
		},
		buttons : [{
		    text : 'Add',
		    action : function(e, dt, node, config) {
			alert('Button activated');
		    }
		}]
	    });
	} 
    }
    
    
    function initBookEditions() {
	
//	  editor = new $.fn.dataTable.Editor({
//	        ajax: bookEditionsUrl,
//	        table: "#editions-table",
//	        fields: [ {
//	                label: "ISBN:",
//	                name: "isbn"
//	            }, {
//	                label: "Start Date:",
//	                name: "startDate",
//	                type: 'datetime'
//	            }, {
//	                label: "END DATE:",
//	                name: "endDate",
//	                type: 'datetime'
//	            }, {
//	                label: "Price:",
//	                name: "price"
//	            }, {
//	                label: "Vat:",
//	                name: "vat"
//	            }, {
//	                label: "Pages :",
//	                name: "pages"
//	            }, {
//	                label: "Salary:",
//	                name: "salary"
//	            }
//	        ]
//	    });
//	 
//	    var table = $('#editions-table').DataTable({
//	        lengthChange: false,
//	        ajax: bookEditionsUrl,
//	        columns: [
//	            { data: "isbn" },
//	            { data: "startDate" },
//	            { data: "endDate" },
//	            { data: "price" },
//	            { data: "vat" }, 
//	            { data: "pages" },
//	            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' )}
//	        ],
//	        select: true
//	    });
	 
//	    // Display the buttons
//	    new $.fn.dataTable.Buttons( table, [
//	        { extend: "create", editor: editor },
//	        { extend: "edit",   editor: editor },
//	        { extend: "remove", editor: editor }
//	    ]);
//	 
//	    table.buttons().container().appendTo( $('.col-sm-6:eq(0)', table.table().container()));
    }

});