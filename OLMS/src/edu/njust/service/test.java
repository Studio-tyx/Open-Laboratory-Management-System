package edu.njust.service;

import edu.njust.DAO.RoomInfoMapper;
import edu.njust.DAO.StudentExpMapper;
import edu.njust.DAO.UserMapper;
import edu.njust.entity.ExperimentInfo;
import edu.njust.entity.RoomInfo;
import edu.njust.entity.StudentExperiment;
import edu.njust.entity.User;
import edu.njust.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;

public class test {
    public static void main(String[] args){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        //LoginService loginService=new LoginService();
        //String rightPassword=loginService.login("918106840236","");
        //System.out.println(rightPassword);
        //boolean isLoginSuccess=loginService.login("918106840236","840236");
        //debug(isLoginSuccess);
        ExperimentService experimentService=new ExperimentService();
//        boolean isInsertSuccess=experimentService.releaseExp
//                (new ExperimentInfo("csp模拟考试","杨彬琪","大三上学期","测试",50));
//        debug(isInsertSuccess);
        //LabService labService=new LabService();
        //List<RoomInfo>rooms=new ArrayList<RoomInfo>();
        //rooms.add(new RoomInfo("1010","2020-12-23",1,50));
        //rooms.add(new RoomInfo("1010","2020-12-23",2,40));
        //boolean result=labService.addNextWeek(rooms);
        //RoomInfoMapper mapper =session.getMapper(RoomInfoMapper.class);
        //int result=mapper.modifyFreeSeat(new RoomInfo("1010","2020-12-23",1,48));
        //int result=mapper.selectFreeSeat("1010","2020-12-23",1);
        //List<String>result=new ArrayList<String>();
        //result=mapper.selectRoomIds();
        //UserMapper mapper=session.getMapper(UserMapper.class);
        //User user=mapper.selectUserById("918106840236");
        //user.show();
        //debug(user.show());
        //StudentExpMapper mapper=session.getMapper(StudentExpMapper.class);
        //debug(mapper.selectStudentExp("918106840236","软件建模","刘冬梅","大三上学期").show());
//        StudentExperiment studentExperiment=new StudentExperiment("918106840242","软件建模","大三上学期","刘冬梅");
//        studentExperiment.setRoomId("1010");
//        studentExperiment.setDate("2020-12-26");
//        studentExperiment.setTime(1);
//        ExperimentService experimentService=new ExperimentService();
        //debug(experimentService.chooseExp(studentExperiment));
        //LabService labService=new LabService();
        //labService.deleteBeforeRoomInfo();
        //experimentService.admitExp(studentExperiment);
        //labService.chooseLab(studentExperiment);
        //List<StudentExperiment> l=new ArrayList<>();
        //l=experimentService.getStudentExperimentsByExpTeacherName("刘冬梅");

//        List<StudentExperiment> l=new ArrayList<StudentExperiment>();
//        l=experimentService.getExperimentByTeacherNameAndExpTermAndExpName("刘冬梅","2020-1","软件建模");
//        for (StudentExperiment l1:l){
//           System.out.println(l1.getRoomId());
//        }
        LoginService loginService=new LoginService();
        loginService.changePassword("1001","1001","1002");

    }

    public static void debug(Object o){
        System.out.println(o.toString());
    }
}
