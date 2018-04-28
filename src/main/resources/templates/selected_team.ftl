<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>${model.country}</title>
    <meta charset="UTF-8">
    <meta name="description" content="Описание">
    <meta name="author" content="Iskander Valiev">
    <link rel="stylesheet" href="/css/homestyle.css">
</head>
<body>
<div class="main">
<#include "tags/header.ftl">
    <div class="content">
        <div class="country">
            <h1>${model.country}</h1>
        </div>
        <div class="squad">
            <table class="teamsquad">
                <tr>
                    <th>#</th>
                    <th>Pos</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
                    <th>Country</th>
                </tr>
                <#list model.players as player>
                    <form action="/playerinfo" method="get">
                        <tr>
                            <td>${player.number}</td>
                            <td>${player.position}</td>
                            <td><input type="submit" name="playerName" value="${player.name}" style="background-color: rgba(0, 0, 0, 0); border: none; color: white;"></td>
                            <td>${player.lastname}</td>
                            <td>${player.age}</td>
                            <td>${model.country}</td>
                        </tr>
                    </form>
                </#list>
            </table>
        </div>
    </div>
</div>
</body>
</html>