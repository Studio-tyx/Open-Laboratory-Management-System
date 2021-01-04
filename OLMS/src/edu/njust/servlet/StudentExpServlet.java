package edu.njust.servlet;

import edu.njust.entity.RoomInfo;
import edu.njust.entity.StudentExperiment;
import edu.njust.entity.User;
import edu.njust.service.ExperimentService;
import edu.njust.service.LabService;
import org.apache.ibatis.jdbc.Null;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author TYX
 * @name StudentExpServlet
 * @description
 * @time
 **/
public class StudentExpServlet extends HttpServlet {

    @Override
    //处理学生预约机房
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //
        String opt=req.getParameter("opt");
        String expName=req.getParameter("expName");
        String expTeacherName=req.getParameter("expTeacherName");
        String expTerm=req.getParameter("expTerm");
        User user= (User) req.getSession().getAttribute("user");
        String stuId=user.getUserId();
        String date=req.getParameter("date");
        LabService labService=new LabService();
        ExperimentService experimentService=new ExperimentService();
        Date _date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today=formatter.format(_date);
        switch (opt){
            case "reserve":
                String roomId=req.getParameter("roomId");
                Integer time=Integer.parseInt( req.getParameter("time"));
                StudentExperiment studentExperiment=experimentService.getStudentExperiment(stuId,expName,expTeacherName,expTerm);
                studentExperiment.setRoomId(roomId);
                studentExperiment.setDate(date);
                studentExperiment.setTime(time);
                labService.chooseLab(studentExperiment);
                req.getSession().setAttribute("info","预约成功");
                req.getRequestDispatcher("/JSP/s/studentExp.jsp").forward(req,resp);

                break;
            case "find":

                if(date==null){
                    String findDate=(String)req.getSession().getAttribute("findDate");
                    if(findDate!=null){
                        date=findDate;
                    }else{
                        date=today;
                    }
                }
                if (date.compareTo(today)>=0){
                    req.getSession().setAttribute("findDate",date);
                    List<RoomInfo> roomInfoList=new ArrayList<>();
                    roomInfoList=labService.getAllRoomInfo(date);
                    System.out.println(roomInfoList.size());
                    req.getSession().setAttribute("roomlist",roomInfoList);
                    req.getRequestDispatcher("/JSP/s/chooseLab.jsp?expName="+expName+
                            "&expTeacherName="+expTeacherName+"&expTerm="+expTerm).forward(req,resp);
                }
                else {
                    req.getSession().setAttribute("info","预约时间已经过了哦~");
                    req.getRequestDispatcher("/JSP/s/chooseLab.jsp").forward(req,resp);
                }

                break;
            default:
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
