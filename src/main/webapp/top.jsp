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
    <title></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="./styles/general.css" rel="stylesheet" type="text/css">
<style type="text/css">
    #header-div{
        background:#278396;
        border-bottom: 1px solid #FFF;
    }
    #logo-div{
        height:50px;
        float:left;
    }
    #submenu-div{
        float:none;
        height:50px;
    }
    #submenu-div ul{
        margin: 3px 20px 0 0;
        padding:0;
        float:right;
        list-style-type:none;

    }
    #submenu-div li{
        float:left;
        padding:0 10px;
        margin: 3px 0;
        border-right: 1px solid #FFF;

    }
    #submenu-div a:visited, #submenu-div a:link{
        color:#FFF;
        text-decoration:none;
    }
    #submenu-div a:hover{
        color:#F5C29A;
    }
    #loading-div{
        clear: right;
        text-align:right;
        display: block;
    }
    #menu-div{
        background: #80BDCB;
        font-weight: bold;
        height: 24px;
        line-height: 24px;
    }
    #menu-div ul{
        margin:0;
        padding:0;
        list-style-type:none;

    }
    #menu-div li{
        float:left;
        border-right:1px solid #192E32;
        border-left:1px solid #BBDDE5;
    }
#menu-div a:visited, #menu-div a:link{
    display:block;
    padding:0 20px;
    text-decoration:none;
    color:#335B64;
    background:#9CCBD6;
}

#menu-div a:hover{
    color:#000;
    background: #80BDCB;
}
#submenu-div a.fix-submenu{
    clear:both;
    margin-left: 5px;
    padding:1px 5px;
    background:#DDEEF2;
    color:#278296;
}
#submenu-div a.fix-submenu:hover{
    padding:1px 5px;
    background: #FFF;
    color:#278296;

}
#menu-div li.fix-spacel{
    width: 30px;
    border-right: none;
}
#menu-div li.fix-spacer{
    border-right: none;
}
#send_info{
    padding:5px 30px 0 0 ;
    clear: right;
    text-align: right;
    color:#FF9900;
    width: 40%;
    float:right;
}

</style>
</head>
<body>
<div id="header-div">
    <div id="logo-div" style="bgcolor:#000000;">
        <img src="img/logo.png" alt="ECSHOP - power for e-commerce"/>

    </div>
    <div id="submenu-div">
        <ul>
            <li><a href="/webapp/WEB-INF/web/html/index.jsp" target="_blank">????????????</a></li>
            <li><a fref="#" target="main-frame">????????????</a></li>
            <li style="border-right:none"><a href="/cms/index.jsp">??????</a></li>

        </ul>
        <div id="send_info">
            <a href="#" target="main-frame" class="fix-submenu">????????????</a>
            <a href="./LoginServlet?cmd=logout" target="_top" class="fix-submenu">??????</a>
        </div>
    </div>
</div>
<div id="menu-div">
    <ul>
        <li class="fix-spacel">&nbsp;</li>
        <li><a href="#" target="main-frame">?????????</a></li>
        <li><a href="#" target="main-frame">????????????</a></li>
        <li><a href="#" target="main-frame">????????????</a></li>
        <li class="fix-spacer">&nbsp;</li>
    </ul>
    <br class="clear">
</div>
</body>
</html>