package edu.njust.DAO;

import java.sql.Date;
import java.util.List;

import edu.njust.entity.RoomInfo;

public interface RoomInfoMapper {

    int insertRoomInfo(RoomInfo roomInfo);

    int deleteBeforeRoomInfo(String date);//删除所有机房某日期以前的记录
    // 可以参考这个 delete from RoomInfo where date &lt; #{param1}

    int modifyFreeSeatCount(RoomInfo roomInfo);

    int selectFreeSeatCount(String roomId,String date,int time);
    List<String> selectRoomIds();//所有机房号的集合
    List<RoomInfo> selectRoom(String date);

}
