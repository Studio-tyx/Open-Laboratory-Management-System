package edu.njust.servlet;

import edu.njust.entity.ExperimentInfo;
import edu.njust.entity.StudentExperiment;
import edu.njust.entity.User;
import edu.njust.service.ExperimentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author TYX
 * @name ExpTeacherServlet
 * @description
 * @time
 **/
public class ExpTeacherServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 老师审核学生报名
     * 获取信息封装成StudentExperiment
     * 调用ExperimentService().admitExp(studentExperiment)
     * 返回true则跳转至expTeacherIndex.jsp
     * 返回false则跳转至failure.jsp
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expteacherName= (String) req.getParameter("expTeacherName");
        String stuId=(String)req.getParameter("stuId");
        String expName=(String)req.getParameter("expName");
        String expTerm=(String)req.getParameter("expTerm");
        StudentExperiment studentExperiment=new StudentExperiment();
        //studentExperiment= (StudentExperiment) req.getAttribute("s");
        ExperimentService experimentService=new ExperimentService();
        studentExperiment=experimentService.getStudentExperiment(stuId,expName,expteacherName,expTerm);
        if (!studentExperiment.hasAdmitted){
            experimentService.admitExp(studentExperiment);
            req.getSession().setAttribute("BoolAdmitted",1);
        }else{
            req.getSession().setAttribute("BoolAdmitted",0);
            req.getRequestDispatcher("/JSP/failure.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/JSP/admitExp.jsp").forward(req,resp);
    }

    /**
     *
     * 获取老师上传实验的相关信息
     * 封装成Experiment
     * 调用ExperimentService.releaseExp方法
     * 增加不成功则跳转至failure.jsp
     * 增加成功则跳转至expTeacherIndex.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user=new User();
        user= (User) req.getSession().getAttribute("user");
        String expTeacherName=user.getUserName();
        String expName=req.getParameter("expName");
        String expTerm=req.getParameter("expTerm");
        String expIntroduction=req.getParameter("expIntroduction");
        ExperimentInfo experimentInfo=new ExperimentInfo(expName,expTeacherName,expTerm,expIntroduction,Integer.parseInt(req.getParameter("expMaxStudentCount")));
        ExperimentService experimentService=new ExperimentService();
        if (experimentService.releaseExp(experimentInfo)){
            req.getSession().setAttribute("BoolRelease",1);
        }else{
            req.getSession().setAttribute("BoolRelease",0);
        }
        req.getRequestDispatcher("/JSP/teacherIndex.jsp").forward(req, resp);
    }
}
