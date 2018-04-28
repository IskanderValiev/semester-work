<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
    <title>Contacts</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <style type="text/css">
        #content {
            position: relative;
        }

        #location {
            background: rgba(255, 255, 255, .9);
            float: right;
            margin: 0px 80px 0px 0px;
            text-align: center;
            position: relative;
            width: 400px;
            height: 350px;
        }

        #location iframe {
            margin: 25px;
        }

        #contact-info {
            text-align: left;
            float: left;
        }

        #contact-info a {
            color: #FFFFFF;
            text-decoration: none;
        }

        #contact-info a:hover {
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div id="container">
<#include "tags/header.ftl">


    <div id="content">
        <div id="location">
            <iframe src="https://yandex.ru/map-widget/v1/-/CBUoEJXRoB" width="350" height="300" frameborder="0"></iframe>
        </div>
        <div id="contact-info">
            World Cup Project<br>
            Kremlyovskaya street, 35<br>
            Kazan<br>
            Tel: +7 (123) 123-45-67<br>
            E-mail: wcproj@gmail.com<br>
            <a href="https://vk.com/welcome_2018" target="_blank">VK</a>
            <a href="https://www.instagram.com/welcome_2018/" target="_blank">Instagram</a>
        </div>
    </div>
</div>
</body>
</html>
