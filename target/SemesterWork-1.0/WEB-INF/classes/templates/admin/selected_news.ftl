<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="/css/homestyle.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="main">
    <div id="header">
        <div id="menu">
            <ul class="menu">
                <li><a href="/worldcup/homepage.jsp">Homepage</a></li>
                <li><a href="/worldcup/matches.jsp">Matches</a>
                    <ul>
                        <li><a href="#">Group A</a></li>
                        <li><a href="#">Group B</a></li>
                        <li><a href="#">Group C</a></li>
                        <li><a href="#">Group D</a></li>
                        <li><a href="#">Group E</a></li>
                        <li><a href="#">Group F</a></li>
                        <li><a href="#">Group G</a></li>
                        <li><a href="#">Group H</a></li>
                    </ul>
                </li>
                <li><a href="/worldcup/cities.jsp">Cities</a>
                    <ul>
                        <li><a href="#">Kazan</a></li>
                        <li><a href="#">Moscow</a></li>
                        <li><a href="#">St. Petersburg</a></li>
                        <li><a href="#">Sochi</a></li>
                        <li><a href="#">Kaliningrad</a></li>
                        <li><a href="#">Saransk</a></li>
                        <li><a href="#">Nizhniy Novgorod</a></li>
                        <li><a href="#">Rostov-On-Don</a></li>
                        <li><a href="#">Volgograd</a></li>
                        <li><a href="#">Ekaterinburg</a></li>
                        <li><a href="#">Samara</a></li>
                    </ul>
                </li>
                <li><a href="#">Stadiums</a></li>
                <li><a href="/teams">Teams</a></li>
                <li><a href="/worldcup/galary.jsp">Galary</a></li>
                <li><a href="/worldcup/contact.jsp">Contacts</a></li>
            </ul>
        </div>
        <div id="profile-menu">
            <ul class="profile-menu">
                <li><a href="/profile">Profile</a></li>
                <li><a href="/exit">Exit</a></li>
            </ul>
        </div>
    </div>
    <hr>
    <div class="newsImage">
        <img src="${model.news.image}">
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
                <div class="user">
                    <div class="user-photo">
                        <img src="${comment.author.photo}" style="width: 128px; height: 128px">
                    </div>
                    <div class="user-name">
                    ${comment.author.name} ${comment.author.lastname}
                            ${comment.date}
                    </div>
                </div>
                <div class="commentText">
                ${comment.content}
                </div>
                <div class="delete-comment">
                    <form method="get" action="/admin/delete/${comment.id}">
                        <input type="image" src="/images/delete-32.png" value="${comment.id}">
                    </form>
                </div>
            </div>
        </#list>
            <div class="post-comment">
                <form action="/postcomment" method="post" class="post-comment-form">
                    <textarea name="text" rows="15" placeholder="Write comment here..." style="width: 100%; resize: none; border-radius: 10px"></textarea>
                    <input type="hidden" name="newsId" value="${model.news.id}">
                    <input type="submit" value="Send.">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>