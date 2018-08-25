$(document).ready(function(){

    $('select#brands').on('click', function(data){

        $value = $(data.target).val();

        $.post( "model-choosing", {'brand' : $value})
            .done(function( data ) {

                var html = "";

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
                for( var key in data){
                    html += "<option>" + data[key] + "</option>";
                }
                $("select#category").html(html);
                $("select#category").val($('select#category option:selected').text());
        });
    });


});