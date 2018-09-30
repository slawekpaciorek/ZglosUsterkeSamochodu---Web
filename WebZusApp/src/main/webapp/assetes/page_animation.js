$(document).ready(function(){

    $('.menu_content').hide();

    $('.menu').find('img').on('click', function () {

        $('.menu_content').slideToggle('slow');

    });
    
    $('.carPanel').hide();
    $('.orderPanel').hide();
    $('.userPanel').hide();

    $('#infoPanel').on('click', function(){
        $('.panels').children().hide();
        $('.infoPanel').show();
    });
    $('#userPanel').on('click', function(){
        $('.panels').children().hide();
        $('.userPanel').show();
    });
    $('#carPanel').on('click', function(){
        $('.panels').children().hide();
        $('.carPanel').show();
    });
    $('#orderPanel').on('click', function(){
        $('.panels').children().hide();
        $('.orderPanel').show();
    });

});