package edu.njust.servlet;

import edu.njust.entity.RoomInfo;
import edu.njust.service.LabService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author TYX
 * @name LabTeacherServlet
 * @description
 * @time
 **/
public class LabTeacherServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt=req.getParameter("opt");
        switch (opt){
            case "add":
                String date=req.getParameter("date");
                req.getSession().setAttribute("findDate",date);
                String time=req.getParameter("time");
                //String Time[4]={"8:00-10:25","10:40-12:15","14:00-15:35","15:50-18:15"};
                String roomId=req.getParameter("roomId");
                String freaCount=req.getParameter("freaCount");
                RoomInfo roomInfo=new RoomInfo(roomId,date,Integer.parseInt(time),Integer.parseInt(freaCount));
                LabService labService=new LabService();
                int result=labService.addRoomInfos(roomInfo);
                labService.deleteBeforeRoomInfo();
                if(result==1){
                    req.getSession().setAttribute("info","添加成功");
                }else{
                    req.getSession().setAttribute("info","修改成功");
                }
                req.getRequestDispatcher("/servlet/LabTeacherServlet?opt=find").forward(req,resp);
            case "deleteAll":


            case "find":
                date=req.getParameter("date");
                if(date==null){
                    String findDate=(String)req.getSession().getAttribute("findDate");
                    if(findDate!=null){
                        date=findDate;
                    }else{
                        Date _date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String today=formatter.format(_date);
                        date=today;
                    }
                }
                req.getSession().setAttribute("findDate",date);
                List<RoomInfo> roomInfoList=new ArrayList<>();
                LabService labService1=new LabService();
                roomInfoList=labService1.getAllRoomInfo(date);
                req.getSession().setAttribute("roomlist",roomInfoList);
                req.getRequestDispatcher("/JSP/lt/showLab.jsp").forward(req,resp);
            default:
                break;
        }

    }
}
