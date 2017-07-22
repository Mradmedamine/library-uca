$(function() {

    var sidebar = $('.nav-side-menu ');
    var menuItems = $(sidebar).find('#menu-content').children('li');

    initMenu(menuItems);

    function initMenu(items) {

	$.each(items, function(index, item) {

	    $(item).on('click', function(event) {
		var item = $(this);
		if (item.isActive()) {
		    collapse(item);
		} else {
		    var openItem = items.filter('.active');
		    if (openItem && openItem.length) {
			collapse(openItem);
		    }
		    unCollapse(item);
		}
	    });

	    if (isCompositeMenuItem(item)) {
		subMenuItems = $(item).next().find('li');
		initMenu(subMenuItems);
	    }
	});

	function collapse(item) {
	    $(item).deactivate();
	    if (isCompositeMenuItem(item)) {
		$(item).uncollapse();
		$(item).next().addClass('collapse');
	    }
	}

	function unCollapse(item) {
	    $(item).activate();
	    if (isCompositeMenuItem(item)) {
		$(item).collapse();
		$(item).next().removeClass('collapse');
	    }
	}

	function isCompositeMenuItem(item) {
	    return $(item).hasClass('composite');
	}

    }

});