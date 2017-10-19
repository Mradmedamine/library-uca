$(function() {

    initBooksDataTables();

    function initBooksDataTables() {
	var booksDataTable = $('#books-datatables');
	if (booksDataTable.length) {
	    $(booksDataTable).DataTable({
		language : dataTablesMessages,
		dom : 'Bfrtip',
		buttons : [ dataTablesPdfBtnLabel ]
	    });
	    var dtBtns = $('#books-container').find('.dt-buttons');
	    styleDtPdfButton(dtBtns);
	}
    }

});