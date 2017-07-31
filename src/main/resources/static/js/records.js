$(function() {

    var recordsUrl = '/records/search';

    initRecordsDataTables();

    $('#toolbar .search-btn').on('click', function(event) {
	var data = $('#toolbar').serializeObject();
	$.ajax({
	    type : 'POST',
	    url : recordsUrl,
	    data : JSON.stringify(data),
	    contentType : 'application/json',
	    success : function(data) {
		$('#result-container').html(data);
		initRecordsDataTables();
	    }
	});
    });

    function initRecordsDataTables() {
	$('#records-dataTables').DataTable({
	    "language" : {
		"emptyTable" : emptySearchResultMessage,
	    }
	});
    }

});