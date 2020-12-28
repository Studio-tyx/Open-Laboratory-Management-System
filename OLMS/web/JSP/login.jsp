<!--
提供账号密码登录
与LoginServlet.doPost相连
-->

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<link href="css/login.css" rel="stylesheet">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<a href="Report/软工测试.doc">下载</a>
<div align="center" class="title_top">南京理工大学开放实验平台</div>
<div class="container">
    <div class="shadow len_top">
        <div class="len_inside">
            <div class="text-center">
                <h1>登录</h1>
            </div>
            <form class="user" action="servlet/LoginServlet" method="post" id="loginForm">
                <!--
         action="/CEIMS/servlet/LoginServlet"
        -->
                <div class="form-group">
                    <input type="text" class="control control-user" name="userId" placeholder="请输入账号" id="userId">
                </div>
                <div class="form-group">
                    <input type="password" class="control control-user" name="password" placeholder="请输入密码" id="password">
                </div>
                <div class="form-group">
                    <span id="msg" style="font-size: 15px; color: red"></span> <br>
                </div>
                <button type="submit" class="btn btn-primary btn-user btn-block" id="loginBtn">登录</button>
                <hr>
            </form>
            <hr>
            <div class="text-center">
                <a class="small" href="register.jsp">注册账号!</a>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#loginBtn").click(function() {
        //获取用户ID、密码
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();

        if(isEmpty(uname)) {
            $("#msg").html("信息不能为空！");
            return;
        }

        if(isEmpty(upwd)) {
            $("#msg").html("信息不能为空！");
            return;
        }
        $("#loginForm").submit();
    });

    //判断字符串是否为空
    function isEmpty(str) {
        if(str == null || str.trim() == "") {
            return true;
        } else return false;
    }
</script>

</html>
