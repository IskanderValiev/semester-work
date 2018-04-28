<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Spring Boot WebSocket Chat Application</title>
    <link rel="stylesheet" href="/css/chat.css" />
</head>
<body>
<div class="chat_window">
    <div class="top_menu">
        <div class="buttons">
            <div class="button close">

            </div>
            <div class="button minimize">

            </div>
            <div class="button maximize">

            </div>
        </div>
        <div class="title">
            Chat
        </div>
    </div>
    <ul class="messages">

    </ul>
    <div class="bottom_wrapper clearfix">
        <div class="message_input_wrapper">
            <input id="message_input_value" class="message_input" placeholder="Type your message here..." />
        </div>
        <div class="send_message">
            <div class="icon">
                <button onclick="connect()">Connect to chat</button>
                <button onclick="disconnect()">Disconnect from chat</button>
                <button onclick="sendMessage()" class="text">Send</button>
            </div>
            <div class="text">
                Send</div>
        </div>
    </div>
</div>
<div class="message_template">
    <li class="message">
        <div class="avatar">

        </div>
        <div class="text_wrapper">
            <div class="text">

            </div>
        </div>
    </li>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/sockjs.min.js"></script>
<script src="/js/stomp.min.js"></script>
<script src="/js/chat.js"></script>
</body>
</html>