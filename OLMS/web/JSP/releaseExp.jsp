<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<link href="css/login.css" rel="stylesheet">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>报名实验</title>
    <link href="JSP/css/base.css" rel="stylesheet">
    <link href="JSP/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="JSP/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="JSP/css/ace.min.css" />
    <link rel="stylesheet" href="JSP/css/style_table.css" />
    <script type="text/javascript" src="JSP/js/jquery.min.js"></script>
</head>

<body style="background-color: #f5f5f5;">
<div class="logo-section box">

    <div>
        <h2 class="logo-title" style="font-size: 28px;color: #1487f4;align-content: center;font-weight: 600;">南京理工大学开放实验教学平台</h2>
    </div>
    <div class="navbar-header pull-right" role="navigation" style="margin-top: -30px; ">
        <div class="get_time" style="background-color: #f5f5f5;"><span id="time"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</div>
<div class="clear"></div>
<!--
作者：offline
时间：2020-12-27
描述：导航栏
-->
<div class="topnav">
    <nav style="margin-left: 60px;">
        <ul id="starlist">

            <li>
                <a href="#">上传实验</a>
            </li>
            <li>
                <a href="#">申请审核</a>
            </li>
            <li>
                <a href="#">报告下载</a>
            <li class="menu">
                <a href="#">帮助</a>
                <ul class="sub" style="margin-left: 0;">
                    <li>
                        <a href="#">规章制度</a>
                    </li>
                    <li>
                        <a href="#">使用说明</a>
                    </li>
                </ul>
                <span></span></li>
            <li class="menu">
                <a href="down-list.html">个人信息</a>
                <ul class="sub" style="margin-left: 0;">
                    <li>
                        <a href="#">基本信息</a>
                    </li>
                    <li>
                        <a href="#">预约记录</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<div class="clear"></div>
<!--
作者：offline
时间：2020-12-27
描述：报名实验
-->

<div class="finalists_style" style="width: 50%; margin-left: 23%;margin-top: 5%;">

    <div class="Manager_style">
        <span class="title_name" style="background-color: #f5f5f5;">实验详细</span>
        <form action="servlet/ExpTeacherServlet" method="post">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <th>实验名称</th>
            <th style="background-color: #fcfcfc;">
                <input name="expName" type="text" style="width: 80%;" id="expName"/>
            </th>
            </thead>

            <thead>
            <th>实验描述</th>
            <th style="background-color: #fcfcfc;">
                <input name="expIntroduction" type="text" style="width: 80%;height: 100px;" id="expIntroduction"/>
            </th>
            </thead>

            <thead>
            <th>实验人数</th>
            <th style="background-color: #fcfcfc;">
                <input name="expMaxStudentCount" type="text" style="width: 21%; float: left; margin-left: 11%;" id="expMaxStudentCount"/>
            </th>

            </tr>
            </thead>
            <thead>
            <th>开课学期</th>

            <th style="background-color: #fcfcfc; ">
                <select name="expTerm" size="1" class="mleft" style="float: left; margin-left: 11%; " id="expTerm">
                    <option value="1">2019至2020-1</option>
                    <option value="2">2020-3至2020-7</option>
                    <option value="3">2020-9至2021-1</option>
                </select>
            </th>
            </tr>
            </thead>
        </table>
            <div class="btn_style">
                <button type="submit" class="btn  btn-danger  save_btn">上传</button>
                <button type="submit" class="btn btn-light Reset_btn">重置</button>
            </div>
        </form>
    </div>


</div>

<!--
作者：offline
时间：2020-12-27
描述：底部描述
-->
<div class="clear blank"></div>
<div class="clear blank"></div>
<div class="clear blank"></div>
<div class="clear blank"></div>
<footer>
    <div class="footer box">
        <div class="endnav">

            <p>1、本站由软件项目管理课程第2小组设计。</p>
            <p>2、如果发现网站存在的问题，欢迎提出建议。联系邮箱：
                <a href="#" target="_blank">wsybkq123@163.com</a>
            </p>
            <p>Copyright © All Rights Reserved.
            </p>
        </div>
    </div>
</footer>
<script src="js/alertify.js"></script>
<script src="js/alertify-init.js"></script>
<script type="text/javascript">
    /*********************点击事件*********************/
    $(document).ready(function() {
        $('#nav_list').find('li.home').click(function() {
            $('#nav_list').find('li.home').removeClass('active');
            $(this).addClass('active');
        });

    })
    //时间设置
    function currentTime() {
        var d = new Date(),
            str = '';
        str += d.getFullYear() + '年';
        str += d.getMonth() + 1 + '月';
        str += d.getDate() + '日';
        str += d.getHours() + '时';
        str += d.getMinutes() + '分';
        str += d.getSeconds() + '秒';
        return str;
    }
    setInterval(function() {
        $('#time').html(currentTime)
    }, 1000);
</script>
</body>

</html>
</body>

</html>