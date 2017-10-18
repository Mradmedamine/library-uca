$(function() {

    var exchangeContainer = $('#exchanges-container');
    
    initExchangesDataTables();

    function initExchangesDataTables() {
	var exchangesDataTable = $('#exchanges-datatables').DataTable({
	    language : dataTablesMessages,
	    dom : 'Bfrtip',
	    buttons : [ dataTablesPdfBtnLabel ]
	});
	var dtBtns = $(exchangeContainer).find('.dt-buttons');
	styleDtPdfButton(dtBtns);
    }

});