$(document).ready(function(){

    $('.menu_content').hide();

    $('.menu').find('img').on('click', function () {

        $('.menu_content').slideToggle('slow');

    });

});