package edu.njust.service;

import edu.njust.DAO.UserMapper;
import edu.njust.entity.User;
import edu.njust.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author TYX
 * @name LoginService
 * @description
 * @time
 **/
public class LoginService {
    /**
     *
     * 比较password与UserMapper.selectPasswordById比较
     * 如果相等则返回true
     * 如果不相等则返回false
     * @param userId
     * @param password
     * @return
     */
    public boolean login(String userId, String password){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        String rightPassword=mapper.selectPasswordById(userId);
        session.close();
        if(password.equals(rightPassword)){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * 返回UserMapper.selectUserById
     * @param userId
     * @return
     */
    public User getUser(String userId){
        SqlSessionFactory factory= DBUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.selectUserById(userId);
        session.close();
        return user;
    }
}
