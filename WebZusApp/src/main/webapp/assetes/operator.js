$(document).ready(function(){

    $('select#brands').on('click', function(data){

        $value = $(data.target).val();

        $.post( "vehicle-choosing", {'brand' : $value})
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

        $.post("model-choosing", {'model': $value})
            .done(function (data) {
               var html = "";
               for(var key in data){
                   html += "<option>" + data[key] + "</option>";
               }

               $("select#version").html(html);
               $("select#version").val($('select#version option:selected').text());

            });

    });

});