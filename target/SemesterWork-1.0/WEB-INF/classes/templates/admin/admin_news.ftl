<!DOCTYPE html>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="/css/homestyle.css">
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
    <div class="news">
        <div class="type">
            <h3>News</h3>
        <#list model.news as news>
            <div class="newsBlock">
                <a href="/admin/news/${news.id}">
                    <img src="${news.image}">
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
                    <img src="${article.image}">
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
                    <img src="${blog.image}">
                    <div class="news_text">
                        <div class="news_header">${blog.header}</div>
                    </div>
                </a>
            </div>
        </#list>
        </div>
    </div>
    <div class="addnews">
        <a href="/admin/addnews">Add News</a>
    </div>
</div>
</body>
</html>
