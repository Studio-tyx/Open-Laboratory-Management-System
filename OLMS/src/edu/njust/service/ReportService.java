package edu.njust.service;

import edu.njust.DAO.StudentExpMapper;
import edu.njust.entity.StudentExperiment;

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
    public boolean addReport(StudentExperiment studentExperiment){
        return false;
    }

    /**
     * getReports
     * @param studentExperiment
     * @return
     * 调用StudentExpMapper().selectReport(studentExperiment)返回报告地址
     */
    public String getReport(StudentExperiment studentExperiment){
        return null;
    }
}
