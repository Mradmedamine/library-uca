$(function() {

    var exchangeContainer = $('#exchanges-container');
    
    initExchangesDataTables();

    $(exchangeContainer).find('#search-form .search-btn').on('click', function(event) {
	var data = $('#search-form').serializeObject();
	$.ajax({
	    type : 'POST',
	    url : '/exchanges/search',
	    data : JSON.stringify(data),
	    contentType : 'application/json',
	    success : function(data) {
		$('#result-container').html(data);
		initExchangesDataTables();
	    }
	});
    });

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