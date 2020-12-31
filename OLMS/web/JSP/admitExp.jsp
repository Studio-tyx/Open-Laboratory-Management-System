<%@ page import="edu.njust.entity.StudentExperiment" %>
<%@ page import="edu.njust.service.ExperimentService" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.njust.entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="edu.njust.service.LoginService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.njust.entity.ExperimentInfo" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
                <a href="JSP/releaseExp.jsp">上传实验</a>
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

<div class="page-content">
    <%  User user=(User) request.getSession().getAttribute("user");//得到用户；
        List<ExperimentInfo> experimentInfoList=new ArrayList<>();//获取老师所有已发布的实验
        ExperimentService experimentService=new ExperimentService();
        experimentInfoList=experimentService.getExperimentByTeacherName(user.getUserName());
        List<StudentExperiment> studentExperiments=new ArrayList<>();
        studentExperiments=experimentService.getStudentExperimentsByExpTeacherName(user.getUserName());
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today=formatter.format(date);
    %>

        <ul class="add_Info_finalists clearfix" style="margin-left: 15%;">
            <form  action="servlet/ExpTeacherServlet?opt=find" method="post">
                <li class="xz_xinxi"><label class="label_name lf">选择学期</label>
                    <%
                        List<String> expTerm=experimentService.getExperimentTermByTeacherName(user.getUserName());
                        int TermSize=expTerm.size();
                    %>
                    <select name="expTerm" size="1" class="mleft" id="expTerm" onchange="changeExpName(this.value)">
                        <%  for(int i=0;i<TermSize;i++){
                        %><option value="<%=i%>"><%=expTerm.get(i)%></option>
                        <%}request.getSession().setAttribute("Term",expTerm);
                        %>
                    </select>
                </li>

                <script>
                    var expTerm=new Array(<%=TermSize%>);
                    <% int index=0;for (;index<TermSize;index++){
                    %>
                    expTerm[<%=index%>]=new Array();
                    <% String insertExpName;
                    List<ExperimentInfo>exps=experimentService.getExperimentByTeacherNameAndExpTerm(user.getUserName(), expTerm.get(index));
                    for(int j=0;j<exps.size();j++){
                        insertExpName=exps.get(j).getExpName();
                    %>
                        expTerm[<%=index%>].push("<%=insertExpName%>");
                    <%}}%>
                </script>

                <li class="xz_xinxi"><label class="label_name lf">选择实验</label>
                    <select name="expName" size="1" class="mleft" id="expName">
                        <%
                            //需要得到第一个学期的实验列表
                            List<ExperimentInfo>exps=new ArrayList<>();
                            exps=experimentService.getExperimentByTeacherNameAndExpTerm(user.getUserName(), expTerm.get(0));
                            for(int i=0;i<exps.size();i++){
                        %>
                        <option value="<%=exps.get(i).getExpName()%>"><%=exps.get(i).getExpName()%></option>
                        <%}%>
                    </select>
                        <input type="submit" value="查找">
                </form>
            </li>
        </ul>
    <script>
        function changeExpName(val){

            //7.获取第二个下拉列表
            var cityEle = document.getElementById("expName");

            //9.清空第二个下拉列表的option内容
            cityEle.options.length=0;

            //2.遍历二维数组中的省份
            for(var i=0;i<<%=TermSize%>;i++){
                //注意，比较的是角标
                if(val==i){
                    //3.遍历用户选择的省份下的城市
                    for(var j=0;j<expTerm[i].length;j++){
                        //4.创建城市的文本节点
                        var textNode = document.createTextNode(expTerm[i][j]);
                        //5.创建option元素节点
                        var opEle = document.createElement("option");
                        //6.将城市的文本节点添加到option元素节点
                        opEle.appendChild(textNode);
                        //8.将option元素节点添加到第二个下拉列表中去
                        cityEle.appendChild(opEle);
                    }
                }
            }
        }
    </script>
    <form id="form1" name="form1" method="post" action="servlet/ExpTeacherServlet?opt=admit">
        <div class="Role_Manager_style">
            <!---->
            <div class="Manager_style" style="width: 70%;margin-left: 15%;">
                <div class="title_name">申请列表</div>
                <div class="Role_list">
                    <table id="Role_list" cellpadding="0" cellspacing="0" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                开课老师
                            </th>
                            <th>课程名称</th>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>状态</th>
                            <th>开课时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%  List<StudentExperiment> studentExperiment=new ArrayList<>();
                            User users=(User) request.getSession().getAttribute("user");//得到用户；
                            List<StudentExperiment> studentExperiment1= new ArrayList<>();
                            String expName= (String) request.getSession().getAttribute("expName");
                            String expTerm1= (String) request.getSession().getAttribute("expTerm");
                            studentExperiment1=experimentService.getExperimentByTeacherNameAndExpTermAndExpName(user.getUserName(),expTerm1,expName);
                            if (studentExperiments!=null){
                            for (StudentExperiment s: studentExperiment1){
                                request.getSession().setAttribute("date",today);
                                User u=new User();
                                LoginService loginService=new LoginService();
                                u=loginService.getUser(s.getStuId());//找到学生姓名
                        %>

                        <tr>
                            <th ><%=s.getStuId()%></th>
                            <td ><%=u.getUserName()%></td>
                            <td ><%=s.getExpTeacherName()%></td>
                            <td ><%=s.getExpTerm()%></td>
                            <td ><%=s.getExpName()%></td>
                            <td ><%=s.hasAdmitted%></td>

                            <td>
                                <div>
                                    <form action="servlet/ExpTeacherServlet" method="post">
                                        <a type="submit" class="btn1 btn-primary waves-effect waves-light" id="alertify-success" href="servlet/ExpTeacherServlet?stuId=<%=s.getStuId()%>&expTeacherName=<%=s.getExpTeacherName()%>&expTerm=<%=s.getExpTerm()%>&expName=<%=s.getExpName()%>&opt=admit">审核通过</a>
                                    </form>
                                </div>

                                <div>

                                    <button type="submit" class="btn1 btn-primary waves-effect waves-light" id="alertify-confirm">审核不通过</button>
                                </div>
                            </td>

                        </tr>
                        <%
                                }}%></tbody>
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
<script>
    $(function() {
        $("#chkAll").chkAll({
        });
        $(".btnedit").click(function() {

            $.jq_Panel({
                title: "修改角色",
                iframeWidth: 500,
                iframeHeight: 300
//						url: "editRole.html"
            });
        });

        $(".btnAdd").click(function() {

            $.jq_Panel({
                title: "添加角色",
                iframeWidth: 500,
                iframeHeight: 300
//						url: "editRole.html"
            });

        });
    });

    function sharesysfun(id) {
        location.href = "shareRole.html";
    }
</script>
</body>

</html>
</body>

</html>