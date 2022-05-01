<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/21
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Title</title>
    <link href="./styles/general.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../plugin/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="./plugin/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="./plugin/ztree/js/jquery.ztree.core.js"></script>
    <style type="text/css">
        body {
            background: #80BDCB;
        }

        #tabbar-div {
            background: #278296;
            padding-left: 10px;
            height: 21px;
            padding-top: 0px;
        }

        #tabbar-div p {
            margin: 1px 0 0 0;
        }

        .tab-front {
            background: #80BDCB;
            line-height: 20px;
            font-weight: bold;
            padding: 4px 15px 4px 18px;
            border-right: 2px solid #335B64;
            cursor: hand;
            cursor: pointer;
        }

        .tab-back {
            color: #F4FAFB;
            line-height: 20px;
            padding: 4px 15px 4px 18px;
            cursor: hand;
            cursor: pointer;
        }

        .tab-hover {
            color: #F4FAFB;
            line-height: 20px;
            padding: 4px 15px 4px 18px;
            cursor: hand;
            cursor: pointer;
            background: #2F9DB5;
        }

        #top-div {
            padding: 3px 0 2px;
            background: #BBDDE5;
            margin: 5px;
            text-align: center;
        }

        #main-div {
            border: 1px solid #345C65;
            padding: 5px;
            marigin: 5px;
            background: #FFF;
        }

        #main-list {
            padding: 0;
            margin: 0;
        }

        #menu-list ul {
            padding: 0;
            margin: 0;
            list-style-type: none;
            color: #335B64;
        }

        #menu-list li {
            padding-left: 16px;
            line-height: 16px;
            cursor: hand;
            cursor: pointer;
        }

        #main-div a:visited, #menu-list a:link, #menu-list a:hover {
            color: #335B64;
            text-decoration: none;
        }

        #menu-list a:active {
            color: #E88A3D;
        }

        .explode {
            /*background: url(./image/menu_minus.gif) red no-repeat 0px 3px;*/
            font-weight: bold;
        }

        .collapse {
            /*background: url(./img/menu_plus.gif) red no-repeat 0px 3px;*/
            font-weight: bold;
        }

        .menu-item {
            /*background:url(/img/menu_arrow.gif) red no-repeat 0px 3px;*/
            font-weight: normal;
        }

        #help-title {
            font-size: 14px;
            color: #000000;
            margin: 5px 0;
            padding: 0px;
        }

        #help-content {
            margin: 0;
            padding: 0;
        }

        .tips {
            color: #CC0000;
        }

        .link {
            color: #000099;

        }

    </style>

    <script type="text/javascript">
        var setting = {};
        //json对象
        var zNodes = [{
            name: "基本功能",
            open: true,
            iconOpen: "./plugin/ztree/css/zTreeStyle/img/diy/1_open.png",
            iconClose: "./plugin/ztree/css/zTreeStyle/img/diy/1_close.png",

            children: [{
                name: "新闻管理",
                url: "/cms/news",
                target: "main-frame"

            }, {
                name: "搜狗",
                url: "http://www.sogou.com/",
                target: "main-frame"
            }, {
                name: "用户管理"
            }]
        }, {
            name: "系统功能",
            open: true,
            children: [{
                name: "数据字典"
            }, {
                name: "广告",
                url: "",
                target: "main-frame"
            },]
        }];
        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        })
    </script>


</head>
<body>
<div id="tabbar-div">
    <p>
        <span class="tab-front" id="menu-tab">菜单</span>

    </p>
</div>
<div id="main-div">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree">
            <li><a href="news" target="main-frame">新闻管理</a></li>
        </ul>
    </div>
</div>
</body>
</html>