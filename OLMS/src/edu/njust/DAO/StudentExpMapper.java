package edu.njust.DAO;

import edu.njust.entity.StudentExperiment;

public interface StudentExpMapper {
    int insertStudentExp(StudentExperiment studentExperiment);

    //修改学生实验信息
    int modifyStudentExp(StudentExperiment studentExperiment);

    //查询报告
    StudentExperiment selectStudentExp(String stuId,String expName,String expTeacherName,String expTerm);
}
