package edu.njust.DAO;

import edu.njust.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //通过userId查询密码
    String selectPasswordById(String userId);
    //通过userId查询user对象
    User selectUserById(String userId);
    boolean changePassword(String newPassWord,String userId);
}
