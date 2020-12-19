package edu.njust.DAO;

import edu.njust.entity.User;

public interface UserMapper {
    String selectPasswordById(String userId);
    User selectUserById(String userId);
}
