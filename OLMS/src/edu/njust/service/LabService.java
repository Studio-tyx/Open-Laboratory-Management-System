package edu.njust.service;

import edu.njust.DAO.RoomInfoMapper;
import edu.njust.DAO.StudentExpMapper;
import edu.njust.entity.RoomInfo;
import edu.njust.entity.StudentExperiment;

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
    public boolean chooseLab(StudentExperiment studentExperiment){
        return false;
    }

    /**
     * delLastWeek
     * @return
     * 首先查找表中所有机房号：RoomInfoMapper().selectRoomId()
     * 对于集合中的某一个机房 得到上周第五天的日期 RoomInfoMapper().selectFirstFriday(之前得到的list.get(0))
     * （其实手算倒推也可以但是我懒emmm 然后所有机房号的日期都是同步的
     * 对于集合中的所有机房 迭代删除上周的记录：RoomInfoMapper().deleteLastWeek()
     */
    public boolean delLastWeek(){
        return false;
    }

    /**
     * addnextweek
     * @param rooms
     * @return
     * 增加下周数据
     * 对于集合中的每个元素 迭代调用RoomInfoMapper().addRoom()
     */
    public boolean addNextWeek(List<RoomInfo> rooms){
        return false;
    }
}
