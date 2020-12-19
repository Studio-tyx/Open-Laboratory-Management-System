package edu.njust.servlet;

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
        super.doGet(req, resp);
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
        super.doPost(req, resp);
    }
}
