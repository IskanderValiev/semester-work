<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Teams</title>
    <meta charset="UTF-8">
    <meta name="description" content="Описание">
    <meta name="author" content="Iskander Valiev">
    <link rel="stylesheet" href="/css/homestyle.css">
</head>
<body>
<div class="main">
<#include "tags/header.ftl">
    <div class="teams">
        <#list model.countries as country>
            <form action="/user/team/${country.id}/players" method="get">
                <div class="team">
                    <input type="image" src="${country.flag}" alt="${country.name}" value="${country.name}" name="countryName">
                    <div class="team_name">
                        <font size="30px">${country.name}</font>
                    </div>
                </div>
            </form>
        </#list>
    </div>
        <#if model.user.role == "ADMIN">
            <div class="add" style="margin: 20px 20px 20px 20px ">
                <a href="/admin/add/team">Add team</a>
            </div>
        </#if>
</div>
</body>
</html>