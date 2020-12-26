package edu.njust.entity;

/**
 * @author TYX
 * @name Experiment
 * @description
 * @time
 **/
public class ExperimentInfo {
    private String expName;
    private String expTeacherName;
    private String expTerm;
    private String expIntroduction;
    private int expMaxStudentCount;
    private int currentStudentCount;

    public ExperimentInfo() {
    }

    public ExperimentInfo(String expName, String expTeacherName, String expTerm, String expIntroduction, int expMaxStudentCount) {
        this.expName = expName;
        this.expTeacherName = expTeacherName;
        this.expTerm = expTerm;
        this.expIntroduction = expIntroduction;
        this.expMaxStudentCount = expMaxStudentCount;
        this.currentStudentCount=0;
    }

    public String show(){
        return "ExperimentInfo: This is an experiment of name:"+this.expName+", teacher name:"+this.expTeacherName+", time:"+this.expTerm+", introduction:"+this.expIntroduction+", max student:"+this.expMaxStudentCount+", now student chosen:"+this.currentStudentCount;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpTeacherName() {
        return expTeacherName;
    }

    public void setExpTeacherName(String expTeacherName) {
        this.expTeacherName = expTeacherName;
    }

    public String getExpTerm() {
        return expTerm;
    }

    public void setExpTerm(String expTerm) {
        this.expTerm = expTerm;
    }

    public String getExpIntroduction() {
        return expIntroduction;
    }

    public void setExpIntroduction(String expIntroduction) {
        this.expIntroduction = expIntroduction;
    }

    public int getExpMaxStudentCount() {
        return expMaxStudentCount;
    }

    public void setExpMaxStudentCount(int expMaxStudentCount) {
        this.expMaxStudentCount = expMaxStudentCount;
    }

    public int getCurrentStudentCount() {
        return currentStudentCount;
    }

    public void setCurrentStudentCount(int currentStudentCount) {
        this.currentStudentCount = currentStudentCount;
    }
}
