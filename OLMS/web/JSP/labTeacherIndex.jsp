<%--
  Created by IntelliJ IDEA.
  User: TYX
  Date: 2020/12/12
  Time: 18:19
  To change this template use File | Settings | File Templates.

  机房老师增加机房时间信息
  LabTeacherServlet.doPost()
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<body>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/";
%>


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
    <script type="text/javascript" src="JSP/js/plugs.js" ></script>
</head>

<body>
<div class="logo-section box">

    <div>
        <h2 class="logo-title" style="font-weight: 600;">南京理工大学开放实验教学平台</h2>
    </div>
    <div class="navbar-header pull-right" role="navigation" >
        <div class="get_time" style="margin-top: -2%;"><span id="time"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</div>
<div class="clear"></div>
<!--
作者：offline
时间：2020-12-27
描述：导航栏
-->
<div class="topnav">
    <nav>
        <ul id="starlist" style="margin-left: 20%;">

            <li>
                <a href="JSP/addLabTable.jsp">安排实验</a>
            </li>
            <li>
                <a href="JSP/chooseLab.jsp">实验室使用</a>
            </li>

            <li class="menu">
                <a href="#">帮助</a>
                <ul class="sub">
                    <li>
                        <a href="#">规章制度</a>
                    </li>
                    <li>
                        <a href="#">使用说明</a>
                    </li>
                </ul>
                <span></span></li>
            <li>
                <a href="down-list.html">个人信息</a>

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
<script src="js/laydate.js" type="text/javascript"></script>
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
<script type="text/javascript">
    laydate({
        elem: '#start',
        event: 'focus'
    });
    $('.smj_btn').on('click', function() {
        layer.open({
            type: 1,

            shadeClose: true,
            area: ['550px', '100%'],
            content: $('#Scan')
        });
    });
</script>
</body>

</html>
</body>

</html>