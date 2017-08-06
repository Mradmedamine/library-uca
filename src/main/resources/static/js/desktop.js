$(function() {

    var desktopPage = $('#page-wrapper');
    
    $(desktopPage).find('#side-menu').metisMenu();
    $(desktopPage).on('click', ".table-uca tr[class*='clickable']", function(e) {
	window.location = $(this).data('href');
    });

    $(window).bind('load resize',function() {
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