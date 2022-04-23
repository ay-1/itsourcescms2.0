<%--  Created by IntelliJ IDEA.
  User: ybl
  Date: 2022/4/22
  Time: 9:55
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="./styles/general.css" rel="stylesheet" type="text/css"/>
    <link href="./styles/main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function validate(){
            //获取username和password元素值
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;
            <%--去掉空值--%>
            var userlength = username.trim().length;
            var passwordlength = password.trim().length;
            if(userlength == 0 || userlength == 0){
                alert("用户名或者密码为空")
                return false;
            }
            if(passwordlength == 0 || passwordlength == 0){
                alert("用户名或者密码为空");
                return false;
            }
            return true;
        }
    </script>
</head>
<body style="background:#278296;color:white">
<form method="post" action="LoginServlet?cmd=login" onsubmit="return validate()">

    <table cellpadding="0" cellpadding="0" style="margin-top:100px;" align="center">
        <tr>
            <td>
                <img src="./img/login.png" width="178" height="256" border="0" alt="ECSHOP">

            </td>
            <td style="padding-left: 50px">
                <table>
                    <span>${errorMsg}</span>
                    <tr>
                        <td>管理员姓名：</td>
                        <td>
                            <input type="text" name="username" id="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>管理员密码：</td>
                        <td>
                            <input type="password" name="password" id="password"/>
                        </td>
                    </tr>
                    <%-- <tr>

                         <td colspan="2" align="center">
                             <input type="checkbox" value="1" name="remember" id="remember"/>
                             <label for="remember">请保存我这次的登录信息。</label>
                         </td>
                     </tr>--%>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="进入管理中心"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <input type="hidden" name="act" value="signin"/>
</form>


</body>
</html>