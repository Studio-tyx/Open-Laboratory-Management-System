package edu.njust.DAO;

import edu.njust.entity.ExperimentInfo;
import edu.njust.entity.StudentExperiment;

import java.util.List;

public interface StudentExpMapper {
    int insertStudentExp(StudentExperiment studentExperiment);

    int deleteStudentExp(StudentExperiment studentExperiment);
    //修改学生实验信息
    int modifyStudentExp(StudentExperiment studentExperiment);


    //查询报告
    StudentExperiment selectStudentExp(String stuId,String expName,String expTeacherName,String expTerm);

    List<StudentExperiment> selectStudentExpsByExpTeacherName(String expTeacherName);

    List<StudentExperiment> getAllStudentExperiment();

    List<StudentExperiment> selectStudentExpsByStuId(String stuId);

    List<StudentExperiment> selectExperimentByTeacherNameAndExpTermAndExpName(String expTeacherName,String expTerm,String ExpName);
}
