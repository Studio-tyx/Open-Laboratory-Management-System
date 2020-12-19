package edu.njust.service;

import edu.njust.DAO.UserMapper;
import edu.njust.entity.User;

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
        return false;
    }

    /**
     *
     * 返回UserMapper.selectUserById
     * @param userId
     * @return
     */
    public User getUser(String userId){
        return null;
    }
}
