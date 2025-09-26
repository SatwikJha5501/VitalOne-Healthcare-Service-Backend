package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int theId);
    User findBySapId(String sapId);
    User save(User theUser);
    void deleteById(int theId);
}