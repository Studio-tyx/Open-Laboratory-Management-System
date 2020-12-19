package edu.njust.entity;

/**
 * @author TYX
 * @name Report
 * @description
 * @time
 **/
public class StudentExperiment {
    private String studentId;
    private String expName;
    private String expTerm;
    private String expTeacherName;
    private String roomId;
    private String date;
    private int time;
    private int seatNo;
    private boolean hasAdmitted;
    private String reportAddr;

    public StudentExperiment() {
    }

    public StudentExperiment(String studentId, String expName, String expTerm, String expTeacherName) {
        this.studentId = studentId;
        this.expName = expName;
        this.expTerm = expTerm;
        this.expTeacherName = expTeacherName;
        this.roomId=null;
        this.date=null;
        this.time=0;
        this.hasAdmitted=false;
    }

    public String show(){
        return "Report: This is a report in address of:"+this.reportAddr+", from student id:"+this.studentId+", experiment name:"+this.expName+", experiment term:"+this.expTerm+", experiment teacher name:"+this.expTeacherName;
    }
}
