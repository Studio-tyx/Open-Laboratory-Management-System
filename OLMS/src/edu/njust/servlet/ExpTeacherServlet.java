package edu.njust.servlet;

import edu.njust.entity.StudentExperiment;
import edu.njust.service.ExperimentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        super.doGet(req, resp);
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
        super.doPost(req, resp);
    }
}
