$(function() {

    var recordsUrl = '/records';
    initRecordsTable();

    $('#toolbar .search-btn').on('click', function(event) {
	var form = $(this).closest('form');
	var data = form.serializeObject();

	$.ajax({
	    url : recordsUrl,
	    data : JSON.stringify(data),
	    dataType : 'json',
	    success : function(result) {
		$('#records-dataTables').html(result);
		initRecordsTable();
	    }
	});
    });

    function initRecordsTable() {
	$('#records-dataTables').DataTable({
	    responsive : true
	});
    }

});