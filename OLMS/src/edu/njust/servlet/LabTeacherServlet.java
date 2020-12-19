package edu.njust.servlet;

import edu.njust.service.LabService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TYX
 * @name LabTeacherServlet
 * @description
 * @time
 **/
public class LabTeacherServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * 获取下周的机房信息并更新数据库
     * 注：数据库中共两周 本周数据信息+下周数据信息 10*5*n(机房数)
     * 删除上周数据：LabService().delLastWeek()
     * 增加下周数据：LabService().addNextWeek()
     * 返回为false跳转至failure.jsp
     * 返回为true跳转至labTeacherIndex.jsp
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
