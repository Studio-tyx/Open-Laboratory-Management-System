package edu.njust.DAO;

import java.sql.Date;
import java.util.List;

import edu.njust.entity.RoomInfo;

public interface RoomInfoMapper {
    int selectNowSeat(RoomInfo roomInfo);
    int modifyFreeSeat(RoomInfo roomInfo);

    List<String> selectRoomId();//所有机房号的集合

    Date selectFirstFriday(String roomId);//找到某机房第一周第五天的日期
    // 可以参考这个 select date from RoomInfo where roomId=#{roomId} order by date desc limit 4,1

    int deleteLastWeek(String roomId, Date date);//删除某机房上一周的记录
    // 可以参考这个 delete from RoomInfo where roomId=#{param1} and date &lt; #{param2}

    int addRoom(RoomInfo roomInfo);
}
