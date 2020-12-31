package edu.njust.servlet;

import edu.njust.entity.RoomInfo;
import edu.njust.service.LabService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String opt=req.getParameter("opt");
        switch (opt){
            case "add":
                String date=req.getParameter("date");
                String time=req.getParameter("time");
                //String Time[4]={"8:00-10:25","10:40-12:15","14:00-15:35","15:50-18:15"};
                String roomId=req.getParameter("roomId");
                String freaCount=req.getParameter("freaCount");
                List<RoomInfo> roomInfos=new ArrayList<>();
                RoomInfo roomInfo=new RoomInfo(roomId,date,Integer.parseInt(time),Integer.parseInt(freaCount));
                roomInfos.add(roomInfo);
                LabService labService=new LabService();
                labService.addRoomInfos(roomInfos);
                req.getRequestDispatcher("/JSP/labTeacherIndex.jsp").forward(req,resp);
            case "deleteAll":


            case "find":
                date=req.getParameter("date");
                List<RoomInfo> roomInfoList=new ArrayList<>();
                LabService labService1=new LabService();
                roomInfoList=labService1.getAllRoomInfo(date);
                req.getSession().setAttribute("roomlist",roomInfoList);
                req.getRequestDispatcher("/JSP/chooseLab.jsp").forward(req,resp);
            default:
                break;
        }

    }
}
