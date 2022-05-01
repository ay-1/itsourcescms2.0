<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/28
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Personal Blog a Blogging Category Flat Bootstarp Responsive Website Template | Single :: w3layouts</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Personal Blog Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"
    />
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!----webfonts---->
    <%--    <link href='http://fonts.googleapis.com/css?family=Oswald:100,400,300,700' rel='stylesheet' type='text/css'>--%>
    <%--    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,300italic' rel='stylesheet' type='text/css'>--%>
    <!----//webfonts---->
    <%--    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <!--end slider -->
    <!--script-->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <!--/script-->
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);
            });
        });
    </script>
    <!---->

</head>
<body>
<!---header---->
<div class="header">
    <div class="container">
        <div class="logo">
            <a href="index.html"><img src="images/logo.jpg" title=""/></a>
        </div>
        <!---start-top-nav---->
        <div class="top-menu">
            <div class="search">
                <form>
                    <input type="text" placeholder="" required="">
                    <input type="submit" value=""/>
                </form>
            </div>
            <span class="menu"> </span>
            <ul>
                <li class="active"><a href="index.html">HOME</a></li>
                <li><a href="about.html">ABOUT</a></li>
                <li><a href="contact.html">CONTACT</a></li>
                <div class="clearfix"></div>
            </ul>
        </div>
        <div class="clearfix"></div>
        <script>
            $("span.menu").click(function () {
                $(".top-menu ul").slideToggle("slow", function () {
                });
            });
        </script>
        <!---//End-top-nav---->
    </div>
</div>
<!--/header-->
<div class="single">
    <div class="container">
        <div class="col-md-8 single-main">
            <div class="single-grid">
                <h2>${news.title }</h2>
                <%--                <img src="images/post1.jpg" alt=""/>--%>
                <p>作者：${news.user.name }</p>
                <p>发布时间：${news.inputDate }</p>
                <p>浏览量:${news.viewCount }</p>

                <p>
                    ${news.context }
                </p>
            </div>
            <ul class="comment-list">
                <h5 class="post-author_head">Written by <a href="#" title="Posts by admin"
                                                           rel="author">${news.user.name }</a></h5>
                <li><img src="images/avatar.png" class="img-responsive" alt="">
                    <div class="desc">
                        <p>View all posts by: <a href="#" title="Posts by admin" rel="author">${news.user.name }</a></p>
                    </div>
                    <div class="clearfix"></div>
                </li>
            </ul>
            <div class="content-form">
                <%--<h3>Leave a comment</h3>
                <form>
                    <input type="text" placeholder="Name" required/>
                    <input type="text" placeholder="Email" required/>
                    <input type="text" placeholder="Phone" required/>
                    <textarea placeholder="Message"></textarea>
                    <input type="submit" value="SEND"/>
                </form>--%>
            </div>
        </div>

        <div class="col-md-4 side-content">
            <div class="recent">
                <h3>推荐新闻</h3>
                <ul>
                    <%--                        <li><a href="#">Aliquam tincidunt mauris</a></li>--%>
                    <c:forEach items="${recommendList }" var="news">
                        <li><a href="./index?cmd=details&newsId=${news.id }">${news.title }</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="comments">
                <h3>最新新闻</h3>
                <ul>
                    <%--                        <li><a href="#">Amada Doe </a> on <a href="#">Hello World!</a></li>--%>
                    <c:forEach items="${recentList }" var="news">
                        <li><a href="./index?cmd=details&newsId=${news.id }">${news.title }</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="clearfix"></div>
            <div class="archives">
                <h3>热门新闻</h3>
                <ul>
                    <c:forEach items="${hotNewsList }" var="news">
                        <li><a href="./index?cmd=details&newsId=${news.id }">${news.title }</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="categories">
                <%--                <h3>CATEGORIES</h3>--%>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Vivamus vestibulum nulla</a></li>--%>
                <%--                    <li><a href="#">Integer vitae libero ac risus e</a></li>--%>
                <%--                    <li><a href="#">Vestibulum commo</a></li>--%>
                <%--                    <li><a href="#">Cras iaculis ultricies</a></li>--%>
                <%--                </ul>--%>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<!---->
<div class="footer">
    <div class="container">
        <p>Copyrights © 2022 Blog All rights reserved | Template by <a href="http://www.baidu.com/">百度</a></p>
    </div>
</div>
</body>