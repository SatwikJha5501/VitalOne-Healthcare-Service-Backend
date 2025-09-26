package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int theId);
    User findBySapId(String sapId);
    User save(User theUser);
    void deleteById(int theId);
}