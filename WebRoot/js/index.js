$(function() {
		$('.left-ul>li').click(function(){
		$(".account-ul li").removeClass("navUlLiOn");
		if($(this).hasClass('active'))
			$(this).removeClass('active').children('ul').stop(true).slideUp(200);
		else
			$(this).addClass('active').children('ul').stop(true).slideDown(200).end()
				.siblings().removeClass('active').children('ul').stop(true).slideUp(200);
	});
	var $left_nav=$('.left-ul li ul li');
	$left_nav.click(function(){

		$(this).addClass("navUlLiOn").siblings().removeClass("navUlLiOn");
		var src=$(this).children().attr('href');
		$('#index_iframe').attr('src',src);
		return false;
	});
	if($left_nav.length > 0) {
		$left_nav[0].click();
	}

	var header_h = $('header').height();
	var $lnav = $('#left_nav');
	//设置iframe和#left_nav大小
	function setSize() {
		// $('#left_nav, #index_iframe').css('height', ($(window).height() - header_h - 5));
	}

	setSize();
	$(window).resize(function() {
		setSize();
	});
})