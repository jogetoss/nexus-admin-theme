$(document).ready(function () {
    const root = document.documentElement; // Select the root element (:root)
    const sidebarWidth = getComputedStyle(root).getPropertyValue('--sidebarWidth').trim();
    $('.page-content-bg').click(function(event) {
        event.stopImmediatePropagation();
        const isRtl = $("body").hasClass("rtl");
        let closeCss = {
            left: '60px'
        };
        if (isRtl) {
            closeCss = {
                right: '60px'
            };
        }
        $('.left-nav .open').click();
        $('.left-nav i').css('font-size', '18px');
        $('.left-nav').animate({
            width: '60px'
        }, 100);
        $('.container .logo a').animate({
            width: '55px'
        }, 100);
        $('.left-nav cite,.left-nav .nav_right').hide();
        $('.page-content').animate(closeCss, 100);
        $(this).hide();
    });
    $('.left-nav #nav').off('click').on('click', 'li', function (event) {
        event.stopImmediatePropagation();
        if ($(this).parent().attr('id') == 'nav') {
            xadmin.set_cate_data({
                key: 'f1',
                value: $('.left-nav #nav li').index($(this))
            })
            xadmin.set_cate_data({
                key: 'f2',
                value: null
            })
            xadmin.set_cate_data({
                key: 'f3',
                value: null
            })
        }
        if ($(this).parent().parent().parent().attr('id') == 'nav') {
            xadmin.set_cate_data({
                key: 'f2',
                value: $('.left-nav #nav li').index($(this))
            })
            xadmin.set_cate_data({
                key: 'f3',
                value: null
            })
        }
        if ($(this).parent().parent().parent().parent().parent().attr('id') == 'nav') {
            xadmin.set_cate_data({
                key: 'f3',
                value: $('.left-nav #nav li').index($(this))
            })
        }
        if ($('.left-nav').css('width') == '60px') {
            $('.left-nav').animate({
                width: sidebarWidth
            }, 100);
            $('.container .logo a').animate({
                width: parseInt(sidebarWidth) - 5
            }, 100);
            $('.page-content').animate({
                left: sidebarWidth
            }, 100);
            $('.left-nav i').css('font-size', '14px');
            $('.left-nav cite,.left-nav .nav_right').show();
        }
        if ($(window).width() < 768) {
            $('.page-content-bg').show();
        }
        $('.left-nav').find('a').removeClass('active');
        $(this).children('a').addClass('active');
        const isRtl = $("body").hasClass("rtl");
        const navRightIcon = isRtl ? '&#xe6a7;' : '&#xe697;';
        if ($(this).children('.sub-menu').length) {
            if ($(this).hasClass('open')) {
                $(this).removeClass('open');
                $(this).find('.nav_right').html(navRightIcon);
                $(this).children('.sub-menu').stop(true, true).slideUp();
                $(this).siblings().children('.sub-menu').slideUp();
            } else {
                $(this).addClass('open');
                $(this).children('a').find('.nav_right').html('&#xe6a6;');
                $(this).children('.sub-menu').stop(true, true).slideDown();
                $(this).siblings().children('.sub-menu').stop(true, true).slideUp();
                $(this).siblings().find('.nav_right').html(navRightIcon);
                $(this).siblings().removeClass('open');
            }
        }
        event.stopPropagation();
    });
    $('.container .left_open i').off('click').click(function (event) {
        event.stopImmediatePropagation();
        const isRtl = $("body").hasClass("rtl");
        let closeCss = {
            left: '60px'
        };
        let openCss = {
            left: sidebarWidth
        };
        if (isRtl) {
            closeCss = {
                right: '60px'
            };
            openCss = {
                right: sidebarWidth
            };
        }
        if ($('.left-nav').css('width') == sidebarWidth) {
            $('.left-nav .open').click();
            $('.left-nav i').css('font-size', '18px');
            $('.left-nav').animate({
                width: '60px'
            }, 100);
            $('.container .logo a').animate({
                width: '55px'
            }, 100);
            $('.left-nav cite,.left-nav .nav_right').hide();
            $('.page-content').animate(closeCss, 100);
            $('.page-content-bg').hide();
        } else {
            $('.left-nav').animate({
                width: sidebarWidth
            }, 100);
            $('.container .logo a').animate({
                width: parseInt(sidebarWidth) - 5
            }, 100);
            $('.page-content').animate(openCss, 100);
            $('.left-nav i').css('font-size', '14px');
            $('.left-nav cite,.left-nav .nav_right').show();
            if ($(window).width() < 768) {
                $('.page-content-bg').show();
            }
        }
    });
});