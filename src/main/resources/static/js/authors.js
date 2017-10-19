$(function() {

    var authorsContainer = $('#authors-container');
    
    initAuthorsDataTables();

    function initAuthorsDataTables() {
	var authorsDataTable = $('#authors-datatables').DataTable({
	    'language' : dataTablesMessages,
	    'columnDefs' : [ {
	        'targets' : [ 4 ],
	        'sorteable' : false
	    } ],
	    dom : 'Bfrtip',
	    buttons : [ dataTablesPdfBtnLabel ]
	});
	var dtBtns = $(authorsContainer).find('.dt-buttons');
	styleDtPdfButton(dtBtns);
    }

});