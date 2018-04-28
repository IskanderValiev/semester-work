<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Homepage</title>
    <meta charset="UTF-8">
    <meta name="description" content="Описание">
    <meta name="author" content="Iskander Valiev">
    <!-- Стили -->
    <link rel="stylesheet" href="/js/slick/slick.css">
    <link rel="stylesheet" href="/js/slick/slick-theme.css">
    <link rel="stylesheet" href="/css/homestyle.css">
    <script type="text/javascript">
        function initializeTimer() {
            var endDate = new Date(2018,5,14); // получаем дату истечения таймера
            var currentDate = new Date(); // получаем текущую дату
            var seconds = (endDate-currentDate) / 1000; // определяем количество секунд до истечения таймера
            if (seconds > 0) {
                var minutes = seconds/60; // определяем количество минут до истечения таймера
                var hours = minutes/60; // определяем количество часов до истечения таймера
                var days = hours/24; //определяем количество дней до истечения таймера
                minutes = (hours - Math.floor(hours)) * 60; // подсчитываем кол-во оставшихся минут в текущем часе
                hours = (days - Math.floor(days)) * 24; // целое количество часов до истечения таймера
                hours = Math.floor(hours); //округляем до целого кол-ва оставшихся часов в текущем дне
                seconds = Math.floor((minutes - Math.floor(minutes)) * 60); // подсчитываем кол-во оставшихся секунд в текущей минуте
                minutes = Math.floor(minutes); // округляем до целого кол-во оставшихся минут в текущем часе
                days = Math.floor(days);
                setTimePage(days,hours,minutes,seconds); // выставляем начальные значения таймера

                function secOut() {
                    if (seconds == 0) { // если секунду закончились то
                        if (minutes == 0) { // если минуты закончились то
                            if (hours == 0) { // если часы закончились то
                                if (days == 0) {
                                    showMessage(timerId); // выводим сообщение об окончании отсчета
                                } else {
                                    days--; //уменьшаем кол-во дней
                                    hours = 23; //обновляем часы
                                    minutes = 59; //обновляем минуты
                                    seconds = 59; //обновляем секунды
                                }
                            } else {
                                hours--; // уменьшаем кол-во часов
                                minutes = 59; // обновляем минуты
                                seconds = 59; // обновляем секунды
                            }
                        } else {
                            minutes--; // уменьшаем кол-во минут
                            seconds = 59; // обновляем секунды
                        }
                    } else {
                        seconds--; // уменьшаем кол-во секунд
                    }
                    setTimePage(days,hours,minutes,seconds); // обновляем значения таймера на странице
                }
                timerId = setInterval(secOut, 1000) // устанавливаем вызов функции через каждую секунду
            } else {
                alert("Установленая дата уже прошла");
            }
        }

        function setTimePage(d,h,m,s) { // функция выставления таймера на странице
            var element = document.getElementById("timer"); // находим элемент с id = timer
            element.innerHTML = "Before World Cup 2018:<br>Days: " + d + " Hours:" + h + " Minutes:" + m + " Seconds:" + s; // выставляем новые значения таймеру на странице
        }

        function showMessage(timerId) { // функция, вызываемая по истчению времени
            alert("Time is left");
            clearInterval(timerId); // останавливаем вызов функции через каждую секунду
        }
    </script>
</head>

<body onload="initializeTimer()">
<div class="main">
<#include "tags/header.ftl">

    <div class="sl">
        <#list model.lastnews as lastnews>
            <div class="sl_slide"><a href="/user/news/${lastnews.id}"><img src="/files/${lastnews.image.storageFileName}" alt="slide 1" class="sl_img">
                <div class="sl_text">
                    <h3 class="sl_header">${lastnews.header}</h3>
                    <#--<p class="sl_desc">Spain secure qualification to next year’s World Cup.</p>-->
                </div>
            </a></div>
        </#list>
    </div>

    <div class="information">
        <div class="block1">
            <a href="/user/news">
                <img src="/images/news.jpg" alt="news" class="info_img">
                <div class="info_text">
                    <h3 class="info_header">News 1</h3>
                    <p class="info_desc">Description</p>
                </div>
            </a>
        </div>
        <div class="block2">
            <a href="#">
                <img src="/images/kazan_block2.jpg" alt="kazan" class="long_info_img">
                <div class="info_text">
                    <h3 class="info_header">News 2</h3>
                    <p class="info_desc">Description</p>
                </div>
            </a>
        </div>
        <div class="block1">
            <a href="#">
                <img src="/images/restaurants.jpg" alt="restaurants" class="info_img">
                <div class="info_text">
                    <h3 class="info_header">News 3</h3>
                    <p class="info_desc">Description</p>
                </div>
            </a>
        </div>
        <div class="block3">
            <a href="#">
                <img src="/images/fans.jpg" alt="fan" class="info_img">
                <div class="info_text">
                    <h3 class="info_header">Fan guide</h3>
                    <p class="info_desc">Everything you need to know about travelling to Russia and staying there to enjoy the World Cup</p>
                </div>
            </a>
        </div>
        <div class="block1">
            <a href="#">
                <img src="/images/vol.jpg" alt="volunteers" class="info_img">
                <div class="info_text">
                    <h3 class="info_header">Volunteer programme</h3>
                    <p class="info_desc">Everything you need to know aboun volunteering</p>
                </div>
            </a>
        </div>
    </div>

    <div id="footer">
        <img src="">
    </div>
</div>
<!-- Конец кода -->
<!-- Подключаем скрипты -->
<script src = "http://yastatic.net/jquery/2.1.3/jquery.min.js"></script>
<script src="/js/slick/slick.min.js"></script>
<script src="/js/js.js"></script>
</body>
</html>
