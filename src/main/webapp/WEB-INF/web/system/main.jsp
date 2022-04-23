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
    <title>main</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">

    <link href="./styles/general.css" rel="stylesheet" type="text/css" />
    <link href="./styles/main.css" rel="stylesheet" typeof="text/css"/>

</head>
<body>
<h1>
    <span class="action-span1" >
        <a href="#">源码快讯 管理中心</a>
    </span>
    <span id="search_id" class="action-span1"></span>
    <div style="clear:both"></div>

</h1>
<div class="list-div">
    <table cellspacing="1" cellpadding="3">
        <tr>
            <th colspan="4" class="group-title">新闻统计信息</th>

        </tr>
        <tr>
            <td width="20%"><a href="#" >新闻总数量：</a></td>
            <td width="30%" ><strong style="color:red">4</strong></td>
            <td width="20%"><a href="#">已发新闻量</a> </td>
            <td width="30%"><strong>2</strong></td>
        </tr>
        <tr>
            <td><a href="#">待发新闻</a> </td>
            <td><strong>3</strong></td>
            <td><a href="#">点赞超100：</a> </td>
            <td><strong>3</strong></td>
        </tr>
        <tr>
            <td><a href="#">热点新闻</a> </td>
            <td><strong>2</strong></td>
            <td><a href="#">推荐新闻：</a> </td>
            <td><strong>0</strong></td>
        </tr>
        <td><a href="#">首页新闻</a> </td>
        <td><strong>1</strong></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </table>
</div>
</body>
</html>