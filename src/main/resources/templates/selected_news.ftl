<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="/css/homestyle.css">
</head>
<body>
<div class="main">
<#include "tags/header.ftl">
    <div class="newsImage">
        <img src="/files/${model.news.image.storageFileName}">
    </div>
    <div class="content">
        <div class="selected-news">

            <div class="newsHeader">
                <span>${model.news.header}</span>
            </div>
            <div class="newsContent">
                <span>${model.news.content}</span>
            </div>
        </div>
        <div class="comments">
            <#list model.comments as comment>
                <div class="comment">
                    <a href="/user/profile/${comment.author.id}">
                        <div class="user">
                            <div class="user-photo">
                                <img src="/files/${comment.author.photo.storageFileName}" style="width: 128px; height: 128px">
                            </div>
                            <div class="user-name">
                                ${comment.author.name} ${comment.author.lastname}
                                <br>
                                ${comment.date}
                            </div>
                        </div>
                        <div class="commentText">
                            ${comment.content}
                        </div>
                        <#if model.user.role == "ADMIN">
                            <div class="delete-comment">
                                <form method="get" action="/admin/delete/${comment.id}">
                                    <input type="image" src="/images/delete-32.png" value="${comment.id}">
                                </form>
                            </div>
                        </#if>
                    </a>
                </div>
            </#list>
            <div class="post-comment">
                <#--action="/postcomment" method="post" -->
                <form class="post-comment-form" id="post-comment-form" action="/postcomment" method="post">
                    <textarea type="text" name="content" id="content" rows="15" placeholder="Write comment here..." style="width: 100%; resize: none; border-radius: 10px" form="post-comment-form"></textarea>
                    <input type="hidden" name="newsId" id="newsId" value="${model.news.id}">
                    <input type="hidden" name="authorId" id="authorId" value="${model.user.id}">
                    <button type="submit" id="btn-comment" value="Send.">Send</button>
                </form>
            </div>
            <div id="feedback"></div>
        </div>
    </div>
</div>
</body>
</html>