
<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/21
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>源码快讯 管理中心</title>
    <meta http-equiv="text/javas" language="JavaScript">
    <script type="Text/Javascript" language="JavaScript">
        if(windows.top != windows){
            windwos.top.location.href=document.location.href;
        }
    </script>
    <frameset rows="76,*" framespacing="0" border="0">
        <frame src="./top.jsp" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
        <frameset cols="180,*" framespacing="0" id="frame-body">
            <frame src="./menu.jsp" id="menu-frame" name="menu-frame" frameborder="no">
            <frame src="news" id="main-frame" name="main-frame" frameborder="no">


        </frameset>

    </frameset>
</head>
<body>

</body>
</html>