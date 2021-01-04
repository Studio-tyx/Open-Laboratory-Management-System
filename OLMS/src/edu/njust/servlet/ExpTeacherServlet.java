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
        doPost(req,resp);

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
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String opt=req.getParameter("opt");

        User user= (User) req.getSession().getAttribute("user");
        String stuId = req.getParameter("stuId");
        String expTeacherName = user.getUserName();
        String expName =  req.getParameter("expName");
        String expTerm="";

        ExperimentService experimentService = new ExperimentService();
        List<StudentExperiment> studentExperiments=new ArrayList<>();
        StudentExperiment studentExperiment=new StudentExperiment();

        System.out.println(opt);
        switch (opt) {
            case "admit":
                expTerm = req.getParameter("expTerm");
                studentExperiment = experimentService.getStudentExperiment(stuId, expName, expTeacherName, expTerm);
                experimentService.admitExp(studentExperiment);
                studentExperiments=experimentService.getStudentExperimentsByExpTeacherName(expTeacherName);
                req.getSession().setAttribute("info","审核成功");
                req.getSession().setAttribute("results",studentExperiments);
                req.getRequestDispatcher("/JSP/et/admitExp.jsp").forward(req,resp);
                break;
            case "admitFail":
                expTerm=req.getParameter("expTerm");
                studentExperiment = experimentService.getStudentExperiment(stuId, expName, expTeacherName, expTerm);
                experimentService.deleteStudentExperiment(studentExperiment);
                req.getSession().setAttribute("info","操作成功");
                studentExperiments=experimentService.getStudentExperimentsByExpTeacherName(expTeacherName);
                req.getSession().setAttribute("results",studentExperiments);
                req.getRequestDispatcher("/JSP/et/admitExp.jsp").forward(req,resp);
                break;
            case "find":
                studentExperiments=experimentService.getStudentExperimentsByExpTeacherName(expTeacherName);
                req.getSession().setAttribute("results",studentExperiments);
                req.getRequestDispatcher("/JSP/et/admitExp.jsp").forward(req,resp);
                break;
            case "release":
                user= (User) req.getSession().getAttribute("user");
                expTeacherName=user.getUserName();
                expName=req.getParameter("expName");
                expTerm=req.getParameter("expTerm");
                String expIntroduction=req.getParameter("expIntroduction");
                ExperimentInfo experimentInfo=new ExperimentInfo(expName,expTeacherName,expTerm,expIntroduction,Integer.parseInt(req.getParameter("expMaxStudentCount")));
                experimentService=new ExperimentService();
                if (experimentService.releaseExp(experimentInfo)){
                    req.getSession().setAttribute("info","发布成功");
                    req.getSession().setAttribute("BoolRelease",1);
                }else{
                    req.getSession().setAttribute("BoolRelease",0);
                }
                req.getRequestDispatcher("/JSP/et/releaseExp.jsp").forward(req, resp);
                break;

            default:
                break;
        }
    }
}
