<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <title>${model.user.name} ${model.user.lastname}</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="main">
    <#include "tags/header.ftl">
        <div id="content">
            <div class="image">
                <img src="/files/${model.user.photo.storageFileName}" width="200" height="200" style="background-color: white;">
                <a href=""></a>
            </div>

            <div class="information">
                <table class="info">
                    <tr>
                        <td><label style="font-size: 40px;">${model.user.name} ${model.user.lastname}</label></td>
                    </tr>
                    <tr>
                        <td><label>Bday: ${model.user.bday}</label></td>
                    </tr>
                    <tr>
                        <td><label>City: ${model.user.city}</label></td>
                    </tr>
                    <tr>
                    <#if model.user.gender?c == "true">
                        <td><label>Gender: Male</label></td>
                    <#else>
                        <td><label>Gender: Female</label></td>
                    </#if>
                    </tr>
                    <tr>
                        <td><label>E-mail: ${model.user.email}</label></td>
                    </tr>
                    <tr>
                        <td><label>Instagram:</label></td>
                    </tr>
                </table>
            </div>
        </div>
</div>
</body>
</html>
