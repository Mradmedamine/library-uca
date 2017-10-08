$(function() {

    initFilesDataTables();

    $('#search-form .search-btn').on('click', function(event) {
	var data = $('#search-form').serializeObject();
	$.ajax({
	    type : 'POST',
	    url : '/files/search',
	    data : JSON.stringify(data),
	    contentType : 'application/json',
	    success : function(data) {
		$('#result-container').html(data);
		initFilesDataTables();
	    }
	});
    });

    function initFilesDataTables() {
	var filesDataTable = $('#files-datatables');
	if (filesDataTable.length) {
	    $(filesDataTable).DataTable(dataTablesConfig);
	}
    }

});