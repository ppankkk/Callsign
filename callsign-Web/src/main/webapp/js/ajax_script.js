$(document).ready(function () {
    $("#morzeButton").click(function () {

        var search = {
            "data" : $("#morzeInput").val(),
            "day" :"1"
        };
        if(search.data.length === 4)
        {
            $.ajax({
                type: "POST",
                contentType : 'application/json; charset=utf-8',
                response: "application/json; charset=utf-8",
                dataType : 'json',
                url: "/code",
                data: JSON.stringify(search), 
                success :function(result) {
                    $("#morzeInput").val('Ваш позывной: ' + result.data.toString().toUpperCase());
                    $("#morzeButton").prop('disabled', true);
                }
            });
        }
    });
});