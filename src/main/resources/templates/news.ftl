<!DOCTYPE html>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="/css/homestyle.css">
</head>
<body>
<div class="main">
<#include "tags/header.ftl">
    <div class="news">
        <div class="type">
            <h3>News</h3>
            <#list model.news as news>
                <div class="newsBlock">
                    <span style="border-radius: 10px; font-size: 14px; background: #971E00; top: 0; left: 42%; position: absolute; z-index: 2; width: 15%">${news.date}</span>
                    <a href="/user/news/${news.id}">
                    <img src="/files/${news.image.storageFileName}">
                    <div class="news_text">
                        <div class="news_header">${news.header}</div>
                    </div>
                    </a>
                </div>
            </#list>
        </div>

        <div class="type">
            <h3>Articles</h3>
            <#list model.articles as article>
                <div class="newsBlock">
                    <a href="/user/news/${article.id}">
                    <img src="/files/${article.image.storageFileName}">
                    <div class="news_text">
                        <div class="news_header">${article.header}</div>
                    </div>
                    </a>
                </div>
            </#list>
        </div>

        <div class="type">
            <h3>Blog</h3>
            <#list model.blogs as blog>
                <div class="newsBlock">
                    <a href="/user/news/${blog.id}">
                    <img src="/files/${blog.image.storageFileName}">
                    <div class="news_text">
                        <div class="news_header">${blog.header}</div>
                    </div>
                    </a>
                </div>
            </#list>
        </div>
    </div>
    <#if model.user.role == "ADMIN">
        <div class="add">
            <a href="/admin/add/news">Add News</a>
        </div>
    </#if>
</div>
</body>
</html>