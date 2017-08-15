$(function() {

	initRecordsDataTables();

	$('#search-form .search-btn').on('click', function(event) {
		var data = $('#search-form').serializeObject();
		$.ajax({
			type : 'POST',
			url : '/records/search',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(data) {
				$('#result-container').html(data);
				initRecordsDataTables();
			}
		});
	});

	function initRecordsDataTables() {
		var recordsDataTable = $('#records-dataTables');
		if (recordsDataTable.length) {
			$(recordsDataTable).DataTable({
				"language" : {
					"emptyTable" : emptySearchResultMessage,
				}
			});
		}
	}

});