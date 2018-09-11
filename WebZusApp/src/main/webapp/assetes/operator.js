$(document).ready(function(){

    $('select#subcategory2').hide();
    $('select#subcategory3').hide();

    $('select#brands').on('click', function(data){

        $value = $(data.target).val();

        $.post( "model-choosing", {'brand' : $value})
            .done(function( data ) {

                var html = "";
                html += "<option selected>Wybierz</option>";

                for (var key in data) {
                    html += "<option>" + data[key] + "</option>";

                }

                $("select#models").html(html);
                $("select#models").val($('select#models option:selected').text());
            });

    });

    $('select#models').on('click', function (data) {

        $value = $(data.target).val();

        $.post("version-choosing", {'model': $value})
            .done(function (data) {
               var html = "";
                html += "<option selected>Wybierz</option>";

                for(var key in data){
                   html += "<option>" + data[key] + "</option>";
               }

               $("select#version").html(html);
               $("select#version").val($('select#version option:selected').text());

            });

    });

    $('select#version').on('click', function (data) {

        $value = $(data.target).val();

        $.post("category-choosing", {'version': $value})
            .done(function (data) {

                var html = "";
                html += "<option selected>Wybierz</option>";

                for( var key in data){
                    html += "<option>" + data[key] + "</option>";
                }
                $("select#category").html(html);
                $("select#category").val($('select#category option:selected').text());
        });
    });

    $('select#category').on('click', function (data) {

        $value = $(data.target).val();

        $.post("subcategory-choosing", {'category': $value})
            .done(function (data) {

                var html = "";
                html += "<option selected>Wybierz</option>";

                for( var key in data){
                    html += "<option>" + data[key] + "</option>";
                }
                $("select#subcategory").html(html);
                $("select#subcategory").val($('select#subcategory option:selected').text());
            });
    });

    $('select#subcategory').on('click', function(data){

        $value = $(data.target).val();

        $.post("subcategory-choosing", {'subcategory' : $value})
            .done(function (data) {

                $('select#subcategory2').show();

                var html = "";
                html += "<option selected>Wybierz</option>";
                for( var key in data){
                    html += "<option>" + data[key] + "</option>";
                }

                $("select#subcategory2").html(html);
                $("select#subcategory2").val($('select#subcategory2 option:selected').text());

            });

    });

    $('select#subcategory2').on('click', function(data){

        $value = $(data.target).val();

        $.post("subcategory-choosing", {'subcategory' : $value})
            .done(function (data) {

                $('select#subcategory3').show();

                var html = "";
                html += "<option selected>Wybierz</option>";
                for( var key in data){
                    html += "<option>" + data[key] + "</option>";
                }

                $("select#subcategory3").html(html);
                $("select#subcategory3").val($('select#subcategory3 option:selected').text());

            });

    });

});