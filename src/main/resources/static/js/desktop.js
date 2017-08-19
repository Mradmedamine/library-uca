$(function() {

	var desktopPage = $('#page-wrapper');

	$(desktopPage).find('#side-menu').metisMenu();
	
	$(document).on('click', ".table-uca .btn-delete", function(event) {
		event.stopPropagation();
		var tr = $(this).closest('tr');
		var url = $(tr).data('href');
		$.ajax({
			type : 'DELETE',
			url :  url,
			contentType : 'application/json',
			success : function(data) {
				// TODO i18n
				if (data == -1) {
					alert('Internal error');
				} else if (data == -100) {
					alert('Referential integrity constraint violation');
				} else {
					var table = $(tr).closest('table').DataTable();
					table.row(tr).remove().draw();
				}
			}
		});
	});
	
	
	
	$(document).on('click', ".table-uca tr[class*='clickable']", function(event) {
		window.location = $(this).data('href')
	});
	
	
	
	$(window).bind('load resize', function() {
		var topOffset = 50;
		var width = (this.window.innerWidth > 0) ? this.window.innerWidth
				: this.screen.width;
		if (width < 768) {
			$('div.navbar-collapse').addClass('collapse');
			topOffset = 100; // 2-row-menu
		} else {
			$('div.navbar-collapse').removeClass('collapse');
		}
		var height = ((this.window.innerHeight > 0) ? this.window.innerHeight
				: this.screen.height) - 1;
		height = height - topOffset;
		if (height < 1)
			height = 1;
		if (height > topOffset) {
			$(desktopPage).css('min-height', (height) + 'px');
		}
	});

	var url = window.location;
	var element = $('ul.nav a').filter(function() {
		return this.href == url;
	}).addClass('active').parent();

	while (true) {
		if (element.is('li')) {
			element = element.parent().addClass('in').parent();
		} else {
			break;
		}
	}

	toastr.options = {
		"closeButton" : false,
		"debug" : false,
		"newestOnTop" : false,
		"progressBar" : false,
		"positionClass" : "toast-bottom-right",
		"preventDuplicates" : false,
		"onclick" : null,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	}

});

var dataTablesConfig = {
	"language" : {
		"emptyTable" : emptySearchResultMessage,
		// TODO i18n
		"info" : "Showing _START_ to _END_ of _TOTAL_ entries",
		"infoEmpty" : "Showing 0 to 0 of 0 entries",
		"infoFiltered" : "(filtered from _MAX_ total entries)",
		"infoPostFix" : "",
		"thousands" : ",",
		"lengthMenu" : "Show _MENU_ entries",
		"loadingRecords" : "Loading...",
		"processing" : "Processing...",
		"search" : "Filter:",
		"zeroRecords" : "No matching records found",
		"paginate" : {
			"first" : "First",
			"last" : "Last",
			"next" : "Next",
			"previous" : "Previous"
		}
	}
}
