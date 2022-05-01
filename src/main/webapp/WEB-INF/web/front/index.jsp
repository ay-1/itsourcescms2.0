<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
</head>
<link rel="stylesheet" type="text/css" href="/styles/index-1.css">
<style>
    #body {
        padding: 0;
        margin: 0;
        text-decoration: none;
        padding: 1%;
    }

    .p-1 {
        width: 80%;
        border: 1px solid pink;
        float: left;
    }

    p {
        margin: 5px;
    }

    #right {
        float: right;
        border: 1px solid red;
        width: 18%;
    }

    h2 {
        margin: 0;
        margin-left: 1em;
    }

    h3 {
        margin: 0 auto;
        text-align: center;
    }

    .hr {

        border: 2px solid aquamarine;
        size: 3px;
    }

    ul > li {
        list-style: none;
        text-decoration: none;
        margin-left: -30px;
        color: black;
        font-size: 15px;
    }

    .r-block {
        margin-top: 20px;


    }

    .p-img {
        margin: 12px 12px;
        float: left;
        width: 200px;
        height: 180px;
    }


</style>
<body>
<div id="body">

    <div class="p-1">
        <div>
            <h2>标题</h2>
            <div>
                <img class="p-img" src="image/stw.png" width="300px;">
            </div>
            <p>
                测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容测试文字内容</p>
        </div>


    </div>
    <div id="right">
        <div>
            <h3>推荐新闻</h3>
            <hr class="hr">
            <ul class="ul">
                <c:forEach items="${recommendList }" var="news">
                    <li><a href="#"></a>${news.title }</li>
                </c:forEach>
            </ul>
        </div>
        <div class="r-block">
            <h3>最新新闻</h3>
            <hr class="hr">
            <ul class="ul">
                <c:forEach items="${recentList }" var="news">
                    <li><a href="#"></a>${news.title }</li>
                </c:forEach>
            </ul>
        </div>
        <div class="r-block">
            <h3>热门新闻</h3>
            <hr class="hr">
            <ul class="ul">
                <c:forEach items="${hotNewsList }" var="news">
                    <li><a href="#"></a>${news.title }</li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>
</body>
</html>
