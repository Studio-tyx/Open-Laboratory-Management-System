package edu.njust.service;

import edu.njust.DAO.RoomInfoMapper;
import edu.njust.DAO.StudentExpMapper;
import edu.njust.entity.RoomInfo;
import edu.njust.entity.StudentExperiment;
import edu.njust.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author TYX
 * @name LabService
 * @description
 * @time
 **/
public class LabService {
    /**
     * chooseLab
     * @param studentExperiment
     * @return
     *
     * 学生选择机房与时间 后台自动分配机位
     * 分配机位：调用StudentExpMapper().selectRemainedSeat()并将返回值赋给studentExperiment的seatNo
     * 更新数据库：调用StudentExpMapper().modifyLabExp(studentExperiment)
     * 空余机位数减少：根据日期时间机房号等信息封装成RoomInfo类
     *      先查询现有空余机位数：RoomInfoMapper().selectNowSeat(roomInfo)
     *      返回值-1之后更新数据库：调用函数RoomInfoMapper.modifyFreeSeat(roomInfo)
     */
    //学生预约实验,即选择机房，请使用基础方法以及studentExperiment对象的roomId,date,time赋好值
    //已测试
    public boolean chooseLab(StudentExperiment studentExperiment){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        StudentExpMapper studentExpMapper=session.getMapper(StudentExpMapper.class);
        RoomInfoMapper roomInfoMapper=session.getMapper(RoomInfoMapper.class);
        //获得机房号和时间
        String roomId=studentExperiment.getRoomId();
        String date=studentExperiment.getDate();
        int time=studentExperiment.getTime();
        //分配seat号
        int seatNo=roomInfoMapper.selectFreeSeatCount(roomId,date,time);
        studentExperiment.setSeatNo(seatNo);
        studentExperiment.setHasAdmitted(true);
        studentExpMapper.modifyStudentExp(studentExperiment);
        //freeCount-1
        RoomInfo roomInfo=new RoomInfo(roomId,date,time,seatNo-1);
        roomInfoMapper.modifyFreeSeatCount(roomInfo);
        session.close();
        return true;

    }

    //机房老师删除今天以前的机房信息
    //已测试
    public boolean deleteBeforeRoomInfo(){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today=formatter.format(date);
        RoomInfoMapper roomInfoMapper=session.getMapper(RoomInfoMapper.class);
        roomInfoMapper.deleteBeforeRoomInfo(today);
        session.close();
        return true;
    }

    //机房老师添加机房信息
    //已测试
    public boolean addRoomInfos(List<RoomInfo> rooms){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        RoomInfoMapper roomInfoMapper=session.getMapper(RoomInfoMapper.class);
        for(int i=0;i<rooms.size();i++){
            roomInfoMapper.insertRoomInfo(rooms.get(i));
        }
        session.close();
        return true;
    }
    //根据日期获取所有的机房
    public List<RoomInfo> getAllRoomInfo(String date){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        RoomInfoMapper roomInfoMapper=session.getMapper(RoomInfoMapper.class);
        List<RoomInfo> results=roomInfoMapper.selectRoom(date);
        session.close();
        return results;
    }

}
