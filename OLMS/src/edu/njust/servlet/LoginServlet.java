package edu.njust.servlet;

import edu.njust.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import edu.njust.entity.*;

/**
 * @author TYX
 * @name LoginServlet
 * @description
 * @time
 **/
public class LoginServlet extends HttpServlet {
    @Override
    /**
     * 获取用户id与密码
     * 调用LoginService.login
     * 如果返回为false 则转到/JSP/failure.jsp
     * 如果返回为true 则调用LoginService.getUser 将User设置为会话属性并根据User.userType跳转至对应的界面
     * 学生->studentIndex.jsp
     * 实验老师->expTeacherIndex.jsp
     * 机房老师->labTeacherIndex.jsp
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //业务逻辑
        String opt=req.getParameter("opt");
        if(opt==null) {
            String userId = req.getParameter("userId");
            String password = req.getParameter("password");
            LoginService loginService = new LoginService();
            boolean isLoginSuccess = loginService.login(userId, password);
            if (isLoginSuccess) {
                User user = loginService.getUser(userId);
                req.getSession().setAttribute("user", user);
                switch (user.getUserType()) {
                    case 1:
                        req.getRequestDispatcher("/JSP/s/chooseExp.jsp").forward(req, resp);
                        break;
                    case 2:
                        req.getRequestDispatcher("/servlet/ExpTeacherServlet?opt=find").forward(req, resp);
                        break;
                    case 3:
                        req.getRequestDispatcher("/servlet/LabTeacherServlet?opt=find").forward(req, resp);
                        break;
                    default:
                }
            } else {
                req.getSession().setAttribute("info","登录失败！");
                req.getRequestDispatcher("/JSP/c/login.jsp").forward(req,resp);
            }
        }else{
            Enumeration<String> em = req.getSession().getAttributeNames();
            while (em.hasMoreElements()) {
                req.getSession().removeAttribute(em.nextElement().toString());
            }
            req.getRequestDispatcher("/JSP/c/login.jsp").forward(req,resp);

        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
