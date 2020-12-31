<%@ page import="java.util.List" %>
<%@ page import="edu.njust.entity.RoomInfo" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
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
    <link rel="stylesheet" href="JSP/css/laydate.css" />
    <script type="text/javascript" src="JSP/js/jquery.min.js"></script>
</head>
<body>
<div class="logo-section box">

    <div>
        <h2 class="logo-title" style="font-weight: 600;">南京理工大学开放实验教学平台</h2>
    </div>
    <div class="navbar-header pull-right" role="navigation">
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
                <a href="#">安排实验</a>
            </li>
            <li>
                <a href="#">实验室使用</a>
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


<div class="page-content">

    <form id="form1" name="form1" method="post" action="servlet/LabTeacherServlet?opt=find">
        <ul class="add_Info_finalists clearfix" style="margin-left: 19%; margin-top: 2%;">
            <li class="xz_xinxi"><label class="label_name lf" style="">选择查看日期</label>
            <input class="mleft" id="start" style=" width: auto;height: 26px;" name="date">
        </li>

    </ul>
        <button type="submit" class="btn  " style="width: 5%;font-size: 8px; background: #428BCA;">查看</button>
        <div class="Role_Manager_style">
            <!---->
            <div class="Manager_style" style="width: 60%;margin-left: 17.5%;">
                <div class="title_name">实验室使用情况</div>
                <div class="Role_list">
                    <table id="Role_list" cellpadding="0" cellspacing="0" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th style="width: ;"></th>
                            <th style="width: ;">8:00-10:25</th>
                            <th style="width: ;">10:40-12:15</th>
                            <th style="width: ;">14:00-15:35</th>
                            <th style="width: ;">15:50-18:15</th>

                        </tr>
                        </thead>
                        <tbody style="">
                        <%  List<RoomInfo> roomInfos= (List<RoomInfo>) request.getSession().getAttribute("roomlist");
                            if (roomInfos!=null){
                            for(int i=1001;i<1003;i++){%>
                            <tr style="">
                                <td><%=i%></td>
                                <%for (int j=1;j<5;j++){
                                    boolean flag=false;
                                    for(int k=0;k<roomInfos.size();k++){
                                        if (roomInfos.get(k).getTime()==j&&roomInfos.get(k).getRoomId().equals(String.valueOf(i))){
                                            flag=true;
                                            break;
                                        }
                                    }
                                    if(flag==true){%>
                                        <td>已安排</td>
                                    <%}else{%>
                                        <td>未安排</td>
                                    <%}}}}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </form>
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
<script src="JSP/js/laydate.js" type="text/javascript"></script>
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