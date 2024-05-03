<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добро пожаловать!</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #6e45e2, #88d3ce);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            transition: background-color 0.5s ease;
        }

        .container {
            text-align: center;
            padding: 50px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 20px;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
            transition: transform 0.3s ease;
        }

        .container.active {
            transform: scale(1.05);
        }

        h1 {
            color: #222;
            font-size: 4em;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
            animation: fadeInDown 1s ease-out;
        }

        p {
            color: #444;
            font-size: 1.5em;
            animation: fadeIn 1s ease-out;
            margin-bottom: 30px;
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            background-color: #6e45e2;
            color: #fff;
            text-decoration: none;
            border-radius: 30px;
            font-size: 1.2em;
            margin-top: 40px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: pulse 2s infinite alternate;
        }

        .btn:hover {
            background-color: #7c5ce8;
            transform: translateY(-3px);
        }

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-50px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes pulse {
            from {
                transform: scale(1);
            }
            to {
                transform: scale(1.1);
            }
        }

        #instructions {
            display: none;
            text-align: left;
            margin-top: 30px;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
            animation: fadeIn 0.5s ease-out;
        }

        #instructions.active {
            display: block;
        }

        .container.active {
            animation: pulse 2s infinite alternate;
        }

        .btn.active {
            animation: pulse 2s infinite alternate;
        }

        @keyframes pulse {
            from {
                transform: scale(1);
            }
            to {
                transform: scale(1.05);
            }
        }

        .btn.active {
            animation: pulse 2s infinite alternate;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Добро пожаловать на мой сайт!</h1>
    <p>Это пример страницы JSP для Apache Tomcat.</p>
    <a href="#" class="btn" onclick="toggleInstructions()">Инструкция</a>
    <div id="instructions">
        <h2>Шаг 1: Развертывание веб-приложений</h2>
        <p>Для развертывания вашего веб-приложения на Tomcat, перейдите на вкладку "Deploy".</p>
        <p>Загрузите ваше WAR-файл (Web Application Archive) с помощью соответствующего поля на этой странице.</p>
        <p>После загрузки, ваше приложение будет автоматически развернуто на Tomcat и будет доступно по соответствующему контекстному пути.</p>
        <h2>Шаг 2: Проверка развернутого приложения</h2>
        <p>Чтобы проверить, что ваше веб-приложение успешно развернуто, перейдите на адрес http://localhost:8080/имя_вашего_приложения в вашем браузере.</p>
        <p>Если все выполнено правильно, вы должны увидеть ваше веб-приложение в браузере.</p>
        <p>Это базовая инструкция по запуску и использованию Apache Tomcat через браузер. Помните, что в зависимости от вашего уровня опыта и конкретных требований вашего проекта, могут потребоваться дополнительные шаги и настройки.</p>
    </div>
    <script>
        function toggleInstructions() {
            var instructionsDiv = document.getElementById("instructions");
            instructionsDiv.classList.toggle("active");
            document.body.classList.toggle("active");
        }
    </script>
</div>
</body>
</html>
