package edu.njust.DAO;

import edu.njust.entity.StudentExperiment;

public interface StudentExpMapper {
    int insertStudentExp(StudentExperiment studentExperiment);
    int modifyAdmittedExp(StudentExperiment studentExperiment);//根据stuId expName expTeacherName expTerm修改hasAdmitted为true
    int modifyLabExp(StudentExperiment studentExperiment);//根据stuId expName expTeacherName expTerm修改lab相关信息
    int selectRemainedSeat(StudentExperiment studentExperiment);//根据date time roomId查找剩余机位（考虑到选定机位之后不能取消 应该是最大seatNo+1）
    int insertReport(StudentExperiment studentExperiment);//根据stuId expName expTeacherName expTerm修改reportAddr
    String selectReport(StudentExperiment studentExperiment);//根据stuId expName expTeacherName expTerm返回reportAddr
}
