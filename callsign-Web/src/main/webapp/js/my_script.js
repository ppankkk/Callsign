$(document).ready(function () {
    $("#morzeButton").click(function () {
        $.ajax({
            url: '/code',
            method: 'GET',
            data: {'data': $("#morzeInput").val(), 'day': 1},
            dataType: "json",
            response: 'text/plain',
            contentType: "application/json; charset=UTF-8",
            accept: "text/plain; charset=utf-8", "Content-Type": "text/plain; charset=utf-8",
            success: function (response) {
                $("#morzeInput").html(response);
            }
        })
    })
});