package edu.njust.entity;

/**
 * @author TYX
 * @name Report
 * @description
 * @time
 **/
public class StudentExperiment {
    private String stuId;
    private String expName;
    private String expTerm;
    private String expTeacherName;
    private String roomId;
    private String date;
    private int time;
    private int seatNo;
    public boolean hasAdmitted;
    private String reportAddr;

    public StudentExperiment() {
    }

    public StudentExperiment(String studentId, String expName, String expTerm, String expTeacherName) {
        this.stuId = studentId;
        this.expName = expName;
        this.expTerm = expTerm;
        this.expTeacherName = expTeacherName;
        this.roomId=null;
        this.date=null;
        this.time=0;
        this.hasAdmitted=false;
    }

    public String show(){
        return "Report: This is a report in address of:"+this.reportAddr+", from student id:"+this.stuId+", experiment name:"+this.expName+", experiment term:"+this.expTerm+", experiment teacher name:"+this.expTeacherName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpTerm() {
        return expTerm;
    }

    public void setExpTerm(String expTerm) {
        this.expTerm = expTerm;
    }

    public String getExpTeacherName() {
        return expTeacherName;
    }

    public void setExpTeacherName(String expTeacherName) {
        this.expTeacherName = expTeacherName;
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

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public boolean isHasAdmitted() {
        return hasAdmitted;
    }

    public void setHasAdmitted(boolean hasAdmitted) {
        this.hasAdmitted = hasAdmitted;
    }

    public String getReportAddr() {
        return reportAddr;
    }

    public void setReportAddr(String reportAddr) {
        this.reportAddr = reportAddr;
    }
}
