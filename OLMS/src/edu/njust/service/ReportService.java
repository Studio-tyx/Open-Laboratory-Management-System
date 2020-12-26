package edu.njust.service;

import edu.njust.DAO.StudentExpMapper;
import edu.njust.entity.StudentExperiment;
import edu.njust.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author TYX
 * @name ReportService
 * @description
 * @time
 **/
public class ReportService {
    /**
     * addReport
     * @param studentExperiment
     * @return
     * 调用StudentExpMapper().insertReport(studentExperiment)增加报告地址
     */
    //保存学生上传报告的url
    public boolean addReport(StudentExperiment studentExperiment){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        StudentExpMapper studentExpMapper=session.getMapper(StudentExpMapper.class);
        studentExpMapper.modifyStudentExp(studentExperiment);
        session.close();
        return true;
    }

    //获得学生报告所在服务器的地址
    public String getReport(String stuId,String expName,String expTeacherName,String expTerm){
        ExperimentService experimentService=new ExperimentService();
        return experimentService.getStudentExperiment(stuId,expName,expTeacherName,expTerm).getReportAddr();
    }
}
