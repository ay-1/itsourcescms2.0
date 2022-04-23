<%--
  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/10
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>添加新闻</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>

    <link href="./styles/general.css" rel="stylesheet" type="text/css"/>
    <link href="./styles/main.css" rel="stylesheet" type="text/css" type="text/css"/>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <script type="text/javascript">
        //编辑功能的新闻类型和是否推荐回退
        var type = document.getElementById('type').value;
        var types = document.getElementsById('types');
        var isRecommend = document.getElementById('isRecommend').value;
        var radios = document.getElementsByName('isRecommend');
        //新闻类型 回显
        for (var i = 0; i < types.length; i++) {
            if (types[i].value == type) {
                //选中要回显的新闻类型
                document.getElementById('types').value = type;
            }
        }
        //是否推荐 回显
        for (var j = 0; j < radios.length; j++) {
            if (isRecommend == radios[j].value) {
                radios[j].check = true;
            } else {
                radios[0].checked = true;
            }

        }

    </script>

</head>

<body>
<h1>
    <span class="action-span"><a href="./news">新闻列表</a> </span>
    <span class="action-span1"><a href="">源码快讯管理中心</a></span>
    <span id="search_id" class="action-span1"> - 添加</span>
    <div style="clear:both"></div>
</h1>
<div class="tab-div">
    <div id="tabbar-div">
        <p>
            <span class="tab-front" id="general-tab">通用信息</span>
        </p>

    </div>
    <div>
        <div id="tabbody-div">
            <form action="./news?cmd=add&newsId=${news.id}" method="post">
                <input type="hidden" id="isRecommend" value="${news.isRecommend}">
                <input type="hidden" id="type" value="${news.newsType.id}">


                <table width="90%" id="general-table" align="center">
                    <tr>
                        <td class="label">新闻标题：</td>
                        <td><input type="text" name="title" value="${news.title}" size="30"/>
                            <span class="require-field">*</span></td>
                    </tr>
                    <%--可选项：单选框--%>
                    <tr>
                        <td class="label">是否推荐</td>
                        <td>是<input type="radio" name="isRecommend" value="true" checked="checked">
                            否<input type="radio" name="isRecommend" value="false"></td>
                        <span class="require-field">*</span>
                    </tr>
                    <%--选项:下拉框--%>
                    <tr>
                        <td class="label">新闻分类：</td>
                        <td>
                            <select id="newsType" name="newsType">
                                <c:forEach items="${newsTypeList}" var="newsType">
                                    <option value="${newsType.id}">${newsType.name}</option>

                                </c:forEach>
                                <%--<option value="5" selected>班级活动</option>--%>
                                <%--<option value="6" >名人事迹</option>--%>


                            </select>
                            <span class="require-field">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td class="label">新闻内容：</td>
                        <td>
                            <%--                            <textarea name="context" cols="80" rows="30"></textarea>--%>
                            <script id="container" name="context" type="text/plain"></script>
                            <%--                            <script id="container" name="context" type="text/plain"></script>--%>

                        </td>
                    </tr>

                </table>
                <div class="button-div">
                    <input type="submit" value="确定" class="button"/>
                    <input type="reset" value="重置" class="button"/>
                </div>

            </form>
        </div>
    </div>
</div>
<%--引入百度富文本编辑器--%>
<%--引入配置文件--%>
<script type="text/javascript" src="./plugin/ueditor/utf8-jsp/ueditor.config.js"></script>

<%--    引入编辑器源码文件--%>
<script type="text/javascript" src="./plugin/ueditor/utf8-jsp/ueditor.all.js"></script>
<%--实例化编辑器--%>
<script type="text/javascript">
    var editor = UE.getEditor('container', {
        initialFrameWidth: 700,//初始化编辑器的宽度
        initialFrameHeight: 1000,//初始化编辑器的高度
        initialContent: '${news.context}',//完成回显
        maxSize: 9
    });
    var text = e.originalEvent.clipboardData.getData("container");
    if (text == "") {
        var items = e.originalEvent.clipboardData.items;
        for (var i = 0, len = items.length; i < len; i++) {
            var item = items[i];
            if (item.kind == 'file' && item.type.indexOf('image/') !== -1) {
                var blob = item.getAsFile();
                getBase64(blob, function (base64) {
                    //sendAndInsertImage(base64,me); 上传到服务器
                    setBase64Image(base64, me);
                });
                //阻止默认事件, 避免重复添加;
                e.originalEvent.preventDefault();
            }
        }
    }
</script>


</body>
</html>
