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
    <title>新闻列表</title>
</head>
<body>
<table border="1" width="500" height="500">
    <caption>新闻信息列表</caption>
    <tr>
        <th>序号</th>
        <th>新闻标题</th>
        <th>点击量</th>
        <th>是否推荐</th>
        <th>类型</th>

    </tr>
    <c:forEach items="${newsList}" var="news">
        <tr>
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td>${news.viewCount}</td>
            <td>${news.isRecommend}</td>
            <td>${news.type_id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
