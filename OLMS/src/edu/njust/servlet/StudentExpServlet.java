package edu.njust.servlet;

import edu.njust.entity.StudentExperiment;
import edu.njust.entity.User;
import edu.njust.service.ExperimentService;
import org.apache.ibatis.jdbc.Null;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TYX
 * @name StudentExpServlet
 * @description
 * @time
 **/
public class StudentExpServlet extends HttpServlet {
    /**
     *
     * 获取学生选择的实验
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * 封装为StudentExperiment类
     * 使用构造器StudentExperiment(String studentId, String expName, String expTerm, String expTeacherName)
     *      该构造器默认教师审批为false
     *      其余实验室相关信息为null
     * 调用ExperimentService.chooseExperiment方法
     * 返回true则跳转至studentIndex.jsp
     * 返回false则跳转至failure.jsp
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expTerm= (String) req.getSession().getAttribute("expTerm");
        User user=(User) req.getSession().getAttribute("user");
        String expName= (String) req.getSession().getAttribute("expName");
        String expTeacherName= (String) req.getSession().getAttribute("expTeacherName");
        String date= (String) req.getSession().getAttribute("date");
        //封装学生实验类
        StudentExperiment studentExperiment=new StudentExperiment(user.getUserId(),expName,expTerm,expTeacherName);
        ExperimentService experimentService= new ExperimentService();
        studentExperiment.setDate(date);
        //findstu为了防止出现相同的学生申请两次
        StudentExperiment findStu=new StudentExperiment();
        findStu=experimentService.getStudentExperiment(user.getUserId(),expName,expTeacherName,expTerm);
        if(findStu==null){
            experimentService.chooseExp(studentExperiment);
            req.getSession().setAttribute("BoolChoose",true);
        }else{
            req.getSession().setAttribute("BoolChoose",false);
        }
        req.getRequestDispatcher("/JSP/chooseExp.jsp").forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 学生选择机房与时间 后台分配机位
     * 返回true则跳转至studentIndex.jsp
     * 返回false则跳转至failure.jsp
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //封装学生类
        String expTerm= (String) req.getSession().getAttribute("expTerm");
        User user=(User) req.getSession().getAttribute("user");
        String expName= (String) req.getSession().getAttribute("expName");
        String expTeacherName= (String) req.getSession().getAttribute("expTeacherName");
        StudentExperiment studentExperiment=new StudentExperiment(user.getUserId(),expName,expTerm,expTeacherName);
        ExperimentService experimentService= new ExperimentService();
        //如果学生的申请通过，可以选择座位与时间；
    }
}
