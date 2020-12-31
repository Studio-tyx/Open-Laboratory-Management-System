package edu.njust.DAO;

import edu.njust.entity.ExperimentInfo;

import java.util.List;

public interface ExpInfoMapper {

    int insertExperimentInfo(ExperimentInfo experimentInfo);

    int modifyExperimentInfo(ExperimentInfo experimentInfo);
    ExperimentInfo selectExperimentInfo(String expName,String expTeacherName,String expTerm);
    List<ExperimentInfo> selectAllExperimentInfo();
    List<ExperimentInfo> selectExperimentInfoByTeacherName(String expTeacher);
    List<ExperimentInfo> selectExperimentByTeacherNameAndExpTerm(String expTeacher,String expTerm);
    List<String> selectExperimentTermByTeacherName(String expTeacherName);

}
