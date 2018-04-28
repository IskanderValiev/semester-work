<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script>
        function sendFile(file) {
            var formData = new FormData();
            formData.append("file", file);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/admin/add/team", true);
            xhr.send(formData);
        }
    </script>
</head>
<body>
<div id="container">
<#include "tags/header.ftl">
    <div class="content">
        <div class="add-team-form">
            <form action="/admin/add/team" method="post" enctype="multipart/form-data">
                <input type="text" name="countryName">
                <input type="file" form="editing" name="photo" id="file" style="width: 100%; margin: 0 0 0 0; float: left">
                <button onclick="sendFile(($('#file'))[0]['files'][0])" class="btn">Upload file</button>
                <input type="hidden" id="file_hidden">
                <div class="filename"></div>
                <input type="submit" value="Add team">
            </form>
        </div>
    </div>
</div>
</body>
</html>