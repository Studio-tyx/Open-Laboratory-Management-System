package edu.njust.DAO;

import edu.njust.entity.ExperimentInfo;

public interface ExpInfoMapper {

    int insertExperimentInfo(ExperimentInfo experimentInfo);

    int modifyExperimentInfo(ExperimentInfo experimentInfo);

    ExperimentInfo selectExperimentInfo(String expName,String expTeacherName,String expTerm);
}
