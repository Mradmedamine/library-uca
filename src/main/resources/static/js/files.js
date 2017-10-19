$(function() {

    var filesContainer = $('#files-container');
    initFilesDataTables();

    function initFilesDataTables() {
	var filesDataTable = $('#files-datatables');
	if (filesDataTable.length) {
	    $(filesDataTable).DataTable({
		language : dataTablesMessages,
		dom : 'Bfrtip',
		buttons : [ dataTablesPdfBtnLabel ]
	    });
	    var dtBtns = $(filesContainer).find('.dt-buttons');
	    styleDtPdfButton(dtBtns);
	}
    }

});