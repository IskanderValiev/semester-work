$( document ).ready(function() {

    // SUBMIT FORM
    $("#post-comment-form").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        // PREPARE FORM DATA
        var formData = {
            comment : $("#content").val(),
            newsId: $("#newsId").val(),
            date: new Date(),
            author: $("#authorId").val()
        };

        $("#btn-comment").prop("disabled", true);

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : window.location,
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                console.log(result);
                $("#btn-comment").prop("disabled", false);
            },
            error : function(e) {
                alert("Error!");
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        $("#comment-content").val("");
        $("#newsId").val("");
    }
})