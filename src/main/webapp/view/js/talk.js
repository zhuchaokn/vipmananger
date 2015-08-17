$(function () {
    $.ajax({
        url: "/ask/question",
        success: function (data) {
            question=data;
            $("#tquestion").html(question.content)
        }
    });
});