<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 17.05.2017
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/style.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="/resources/css/fomsElements.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="/resources/css/commodity.css" media="screen" type="text/css" />
    <!--Ajax-->
    <script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.11/jquery.mousewheel.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jScrollPane/2.0.14/jquery.jscrollpane.min.js'></script>
    <!--/Ajax-->

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js"></script>

    <script src="/resources/scripts/main.js"></script>
    <script src="/resources/scripts/modal_window_script.js"></script>
    <script src="/resources/scripts/cart_scripts.js"></script>
    <script src="/resources/scripts/adminScripts.js"></script>
</head>
<body>
<div><tiles:insertAttribute name="header"/></div>
<div><tiles:insertAttribute name="menu"/></div>
<div><tiles:insertAttribute name = "body"/></div>
<div><tiles:insertAttribute name = "footer"/></div>
<div id = "modalWin" class="windowBelow"></div>
<audio id = "audio"><source src="/resources/sounds/switch-20.mp3"></audio>
<audio id = "audio1"><source src="/resources/sounds/briefcase-lock-7.mp3"></audio>
</body>
</html>
