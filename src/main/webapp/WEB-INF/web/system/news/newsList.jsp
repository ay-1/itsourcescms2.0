<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/4
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/3/30
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>源码快讯 管理中心-新闻列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="./styles/general.css" rel="stylesheet" type="text/css">
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>
    <span class="action-span"><a href="./news?cmd=input">添加新闻</a> </span>
    <span class="action-span1"><a href="./news">源码快讯 管理中心-新闻列表</a> </span>
    <div style="clear:both"></div>
</h1>
<form class="form-div" action="news" name="searchForm" method="post">
    <img src="./img/icon_search.gif" width="26" hight="22" border="0" alt="search"/>
  <%--  <!--分类-->
    <select name="cat_id">
        <option value="0">新闻分类</option>
        <foreach name="cat_list" item="val">
            <option value="<{$val.cat_id}>"><{$val.lev|str_repeat='&nbsp;&nbsp;',###}><{$val.cat_id}></option>
        </foreach>
    </select>--%>
    <!--推荐-->

        是否推荐<select name="isRecommend">

            <option value="">--全部--</option>
            <option value="true">是</option>
            <option value="false">否</option>

        </select>
    <!--关键字-->
        关键字<input type="text" name="keyword" size="15">
        <input type="submit" value=" 搜索" class="button">
</form>
</div>
        <!--商品列表-->
        <form method="post" action="" name="listForm" >
            <div class="list-div" id="listDiv">
                <table cellpadding="3" cellspacing="1">
                    <th>序号</th>
                    <th>新闻标题</th>
                    <th>新闻类型</th>
                    <th>是否推荐</th>
                    <th>点击量</th>
                    <th>录入时间</th>
                    <th>录入人</th>
                    <th>操作</th>
                    <c:forEach items="${newsList}" var="news">

                    <tr>
                        <td align="center">${news.id }</td>
                        <td align="center" class="first-cell">${news.title }</td>
                        <td align="center">${news.newsType.name }</td>
                        <td align="center">

                            <c:if test="${news.isRecommend == true }">
                                <img src="img/yes.gif"></c:if>
                                <c:if test="${news.isRecommend == false }">
                                <img src="img/no.gif"></c:if>
                        </td>
                        <td align="center">${news.viewCount }</td>
                        <td align="center">${news.inputDate }</td>
                        <td align="center">${news.user.name }</td>
                        <td align="center">
                            <a href="" target="_blank" title="查看"><img src="img/icon_view.gif" width="16" height="16" border="0"/>&nbsp;</a>
                            <a href="./news?newsId=${news.id}&cmd=input" title="编辑"><img src="img/icon_edit.gif" width="16" height="16" border="0"/>&nbsp;</a>
                            <a href="./news?newsId=${news.id}&cmd=delete" title="回收站"><img src="img/icon_trash.gif" width="16" height="16" border="0"/>&nbsp;</a>
                        </td>
                    </tr>

                    </c:forEach>
                </table>
                <!--分页开始-->
                <table id="page-table" cellspacin="0">
                    <tr>
                        <td width="80%">&nbsp;</td>
                        <td align="center" nowrap="true">显示分页条</td>
                    </tr>
                </table>
                <!--分页结束-->
            </div>
        </form>
        <div id="footer" align="center">
            ……
        </div>

    </select>
</body>
</html>

