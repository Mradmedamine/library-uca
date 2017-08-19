$(function() {

	initBooksDataTables();

	$('#search-form .search-btn').on('click', function(event) {
		var data = $('#search-form').serializeObject();
		$.ajax({
			type : 'POST',
			url : '/books/search',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(data) {
				$('#result-container').html(data);
				initBooksDataTables();
			}
		});
	});

	function initBooksDataTables() {
		var booksDataTable = $('#books-datatables');
		if (booksDataTable.length) {
			$(booksDataTable).DataTable(dataTablesConfig);
		}
	}

});