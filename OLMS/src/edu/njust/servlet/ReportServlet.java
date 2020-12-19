package edu.njust.servlet;

import edu.njust.service.ReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TYX
 * @name ReportServlet
 * @description
 * @time
 **/
public class ReportServlet extends HttpServlet {
    /**
     * doGet
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 老师获取报告
     * 将学生信息封装成StudentExperiment
     * 调用ReportService().getReport()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * doPost
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 学生上传报告
     * 将信息封装成StudentExperiment
     * 调用ReportService().addReport()
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
