<%--
  Created by IntelliJ IDEA.
  User: TYX
  Date: 2020/12/12
  Time: 18:20
  To change this template use File | Settings | File Templates.

  实验老师下载报告
  ReportServlet.doGet()
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="edu.njust.entity.ExperimentInfo" %>
<%@ page import="edu.njust.service.ExperimentService" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="edu.njust.entity.User" %>
<%@ page import="edu.njust.entity.StudentExperiment" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>报名实验</title>
    <link href="JSP/css/base.css" rel="stylesheet">
    <link href="JSP/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="JSP/css/style.css" rel="stylesheet" type="text/css">
    <!--<link rel="stylesheet" href="css/ace.min.css" />-->
    <script type="text/javascript" src="JSP/js/jquery.min.js"></script>
</head>

<body>
<div class="logo-section box">
    <div>
        <h2 class="logo-title">南京理工大学开放实验教学平台</h2>
    </div>
    <div class="navbar-header pull-right" role="navigation">
        <div class="get_time"><span id="time"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
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
        <ul id="starlist">

            <li>
                <a href="#">实验报名</a>
            </li>
            <li>
                <a href="#">实验室预约</a>
            </li>
            <li class="menu">
                <a href="#">实验报告</a>
                <ul class="sub">
                    <li>
                        <a href="#">提交报告</a>
                    </li>
                    <li>
                        <a href="#">文件下载</a>
                    </li>
                </ul>
                <span></span></li>
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
            <li class="menu">
                <a href="down-list.html">个人信息</a>
                <ul class="sub">
                    <li>
                        <a href="#">基本信息</a>
                    </li>
                    <li>
                        <a href="#">成绩查询</a>
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
<div class="content-page">
    <div class="">
        <div class="col-xl-9">
            <div class="card">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col" style="width: 10%;">编号</th>
                            <th scope="col" style="width: 20%;">实验名称</th>
                            <th scope="col" style="width: 20%;">上课教师</th>
                            <th scope="col" style="width: 30%;">开设学期</th>

                            <th scope="col">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%  List<ExperimentInfo> experimentInfos=new ArrayList<>();
                            ExperimentService experimentService=new ExperimentService();
                            User user=(User) session.getAttribute("user");
                            experimentInfos=experimentService.selectAllExperimentInfo();
                            Date date = new Date(); // this object contains the current date value
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            String today=formatter.format(date);
                            int number=1;
                            for (ExperimentInfo e:experimentInfos){
                                request.getSession().setAttribute("date",today);
                        %>
                        <tr>
                            <th scope="row">#<%=number%></th>
                            <td><%=e.getExpName()%><%request.getSession().setAttribute("expName",e.getExpName());%></td>
                            <td><%=e.getExpTeacherName()%><%request.getSession().setAttribute("expTeacherName",e.getExpTeacherName());%></td>
                            <td><%=e.getExpTerm()%><%request.getSession().setAttribute("expTerm",e.getExpTerm());%></td>

                            <td>
                                <form enctype="multipart/form-data" method="post" action="servlet/ReportServlet">
                                    <input type="file" name="file1"><br>
                                    <button type="submit">提交</button>
                                </form>
                            </td>
                        </tr>
                        <%  number++;
                        }%>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>

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
<script src="JSP/js/alertify.js"></script>
<script src="JSP/js/alertify-init.js"></script>
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