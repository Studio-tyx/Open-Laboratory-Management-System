package edu.njust.service;

import edu.njust.DAO.StudentExpMapper;
import edu.njust.entity.ExperimentInfo;
import edu.njust.entity.StudentExperiment;

/**
 * @author TYX
 * @name RegisterExp
 * @description
 * @time
 **/
public class ExperimentService {
    /**
     * releaseExp
     * @param experimentInfo
     * @return
     *
     * 调用ExpInfoMapper.insertExperiment方法
     * 添加成功返回true
     * 添加失败返回false
     */
    public boolean releaseExp(ExperimentInfo experimentInfo){
        return false;
    }

    /**
     * chooseExp
     * @param studentExperiment
     * @return
     * 学生报名某个实验
     * 调用StudentExpMapper.insertExperiment
     */
    public boolean chooseExp(StudentExperiment studentExperiment){
        return false;
    }

    /**
     * admitExp
     * @param studentExperiment
     * @return
     *
     * 实验老师审核学生报名
     * 调用StudentExpMapper().modifyAdmittedExp()
     * 该实验当前选择人数+1：RoomInfoMapper().modifyFreeSeat()
     */
    public boolean admitExp(StudentExperiment studentExperiment){
        return false;
    }


}
