$(document).ready(function () {
    $("#morzeButton").click(function () {

        var search = {
            "data" : $("#morzeInput").val(),
            "day" :"1"
        };

        $.ajax({
            type: "POST",
            contentType : 'application/json; charset=utf-8',
            response: "application/json; charset=utf-8",
            dataType : 'json',
            url: "/code",
            data: JSON.stringify(search), // Note it is important
            success :function(result) {
                $("#morzeInput").val('Ваш позывной: ' + result.data.toString().toUpperCase());
                $("#morzeButton").setAttribute("disabled", "true");
            }
        });
    });

    $("#morzeInput").focus(function () {
        $("#morzeButton").setAttribute("disabled", "false");
    });

    function myFunction() {
        document.getElementById("morzeButton").disabled = false;
        document.getElementById("morzeInput").val('');
    }

    function myFunction2() {
        document.getElementById("morzeButton").disabled = true;
        // document.getElementById("morzeInput").val('');
    }
});