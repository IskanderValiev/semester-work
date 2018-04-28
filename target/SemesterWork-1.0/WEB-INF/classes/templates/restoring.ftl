<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restoring password</title>
    <link rel="stylesheet" href="/css/style.css">
    <style type="text/css">
        hr {
            width: 100%;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="main">
    <div id="header">
        <span style="margin-left: 100px; font-size: 25px">Restoring password</span>
    </div>
    <hr>
    <div class="content" style="text-align: center; font-size: 30px;">
        <span style="width: 400px;">Please, input your email below:</span>
        <form action="/tempPassword" method="post">
            <input type="text" name="email" placeholder="E-mail" style="border-radius: 10px; height: 30px; width: 300px; font-size: 25px;">
            <input type="submit" value="send" style="height: 30px; border-radius: 10px; font-size: 20px;">
        </form>
    </div>
</div>
</body>
</html>