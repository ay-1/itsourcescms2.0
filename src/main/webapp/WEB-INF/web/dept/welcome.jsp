<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/25
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>源码快讯</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>


</head>
<body>
<div id="head">
    <div class="wrap">
        <div class="logo"><a href="index.heml"><img src="image/logo.png"></a></div>
        <div class="nav">
            <ul>
                <li class="active"><a href="./WEB-INF/web/dept/index.jsp">主页</a></li>
                <li><a href="#">关于我们</a></li>
                <li><a href="#">联系我们</a></li>

            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div id="header">
    <div class="wrap">
        <div class="sub-header">
            <img src="image/monitor.png" alt="" width="310" class="mac"/>
            <div class="desp"><h1>我们的介绍</h1>
                <p>源码时代依托于国内开源团队EasyJF”和国内开源社区“开源人社区”，采用"“先入学，后归源码时代拥有一支资深讲师团队，他们都曾在国内大中型企业任职，曾担任技术总监、软件架构师.
                </p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div id="main">
    <div class="wrap">
        <div class="content">
            <div id="article">
                <h2>企业评价</h2>
                <div id="prev"><img src="image/stw.png alt="></div>
                <p>
                    真没想到。皮届毕业生的项目经验会这么丰富,在跟一个员工深入交渣后,我才<br/>
                    我发现源码封代培训出来的学生快摔键使用的非常灵活，敲代码的速崖也很快，石
                </p>
                <div class="clear"></div>
            </div>
            <div id="article">
                <h2>行业前景</h2>
                <div id="prev"><img src="image/stw.png alt="></div>
                <p>
                    真没想到。皮届毕业生的项目经验会这么丰富,在跟一个员工深入交渣后,我才<br/>
                    我发现源码封代培训出来的学生快摔键使用的非常灵活，敲代码的速崖也很快，石
                </p>
                <div class="clear"></div>
            </div>
        </div>
        <div class="copyrights">Collect from<a href="http://www.sccmaban.com/">企业文化</div>
        <div class="sidebar">
            <div class="sub-sidebar">
                <h2>推荐新闻</h2>
                <ul class="sub-nav">
                    <c:forEach items="${recommendList }" var="news">
                        <li><a href="#"></a>${news.title }</li>
                    </c:forEach>

                </ul>
            </div>
            <div class="sub-sidebar">
                <h2>最新新闻</h2>
                <ul class="sub-nav">
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <div><a href="#">5</a>
                </ul>
                </ul>

            </div>
        </div>
    </div>
</div>


</body>
</html>
