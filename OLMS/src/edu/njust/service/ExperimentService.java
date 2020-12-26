package edu.njust.service;

import edu.njust.DAO.ExpInfoMapper;
import edu.njust.DAO.RoomInfoMapper;
import edu.njust.DAO.StudentExpMapper;
import edu.njust.DAO.UserMapper;
import edu.njust.entity.ExperimentInfo;
import edu.njust.entity.RoomInfo;
import edu.njust.entity.StudentExperiment;
import edu.njust.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
    //实验老师发布实验
    //已测试
    public boolean releaseExp(ExperimentInfo experimentInfo){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        ExpInfoMapper expInfoMapper=session.getMapper(ExpInfoMapper.class);
        int line=expInfoMapper.insertExperimentInfo(experimentInfo);
        session.close();
        if(line==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * chooseExp
     * @param studentExperiment
     * @return
     * 学生报名某个实验
     * 调用StudentExpMapper.insertExperiment
     */
    //学生报名实验（参数为基础方法的返回值）
    //已测试
    public boolean chooseExp(StudentExperiment studentExperiment){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        StudentExpMapper studentExpMapper=session.getMapper(StudentExpMapper.class);
        int line=studentExpMapper.insertStudentExp(studentExperiment);
        session.close();
        if(line==1){
            return true;
        }else{
            return false;
        }
    }


    //实验老师同意某个学生的实验报名（参数为基础方法的返回值）
    //已测试
    public boolean admitExp(StudentExperiment studentExperiment){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        studentExperiment.setHasAdmitted(true);
        StudentExpMapper studentExpMapper=session.getMapper(StudentExpMapper.class);
        studentExpMapper.modifyStudentExp(studentExperiment);
        ExpInfoMapper expInfoMapper=session.getMapper(ExpInfoMapper.class);
        ExperimentInfo experimentInfo=expInfoMapper.selectExperimentInfo(studentExperiment.getExpName(),
                studentExperiment.getExpTeacherName(),studentExperiment.getExpTerm());
        experimentInfo.setCurrentStudentCount(experimentInfo.getCurrentStudentCount()+1);
        expInfoMapper.modifyExperimentInfo(experimentInfo);
        session.close();
        return true;
    }

    //基础方法:根据4个key取StudentExperiment
    public StudentExperiment getStudentExperiment(String stuId,String expName,String expTeacherName,String expTerm){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        StudentExpMapper studentExpMapper=session.getMapper(StudentExpMapper.class);
        StudentExperiment studentExperiment=studentExpMapper.selectStudentExp(stuId,expName,expTeacherName,expTerm);
        session.close();
        return studentExperiment;
    }
}
