package edu.njust.entity;
import java.sql.Date;

/**
 * @author TYX
 * @name RoomInfo
 * @description
 * @time
 **/
public class RoomInfo {
    private String roomId;
    private String date;
    private int time;
    private int freeCount;
    public RoomInfo() {
    }

    public RoomInfo(String roomId, String date, int time, int freeCount) {
        this.roomId = roomId;
        this.date = date;
        this.time = time;
        this.freeCount = freeCount;
    }

    public String show(){
        return "RoomInfo: This is a room id:"+this.roomId+", which has "+this.freeCount+" remained seats when "+this.time+" class of "+this.date;
    }

    public void setFreeCount(int freeCount) {
        this.freeCount = freeCount;
    }

    public int getFreeCount() {
        return freeCount;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
