package edu.njust.DAO;

import edu.njust.entity.ExperimentInfo;

public interface ExpInfoMapper {
    /**
     * insertExperiment
     * @param experiment
     * @return
     *
     * 新增实验信息
     */
    int insertExperiment(ExperimentInfo experiment);
}
