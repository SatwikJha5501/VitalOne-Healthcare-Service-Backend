package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.User;
import com.UPZEN.VitalOne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        User theUser = userService.findById(userId);
        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        return theUser;
    }

    @PostMapping
    public User addUser(@RequestBody User theUser) {
        theUser.setId(0);
        return userService.save(theUser);
    }

    @PutMapping
    public User updateUser(@RequestBody User theUser) {
        return userService.save(theUser);
    }

    @PatchMapping("/{userId}")
    public User patchUser(@PathVariable int userId, @RequestBody User patchUser) {
        User existingUser = userService.findById(userId);

        if (existingUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        if (patchUser.getFirstName() != null) {
            existingUser.setFirstName(patchUser.getFirstName());
        }
        if (patchUser.getLastName() != null) {
            existingUser.setLastName(patchUser.getLastName());
        }
        if (patchUser.getBatch() != null) {
            existingUser.setBatch(patchUser.getBatch());
        }
        if (patchUser.getBranch() != null) {
            existingUser.setBranch(patchUser.getBranch());
        }
        if (patchUser.getSpecialization() != null) {
            existingUser.setSpecialization(patchUser.getSpecialization());
        }
        if (patchUser.getEmail() != null) {
            existingUser.setEmail(patchUser.getEmail());
        }
        if (patchUser.getMobileNumber() != null) {
            existingUser.setMobileNumber(patchUser.getMobileNumber());
        }
        if (patchUser.getStatus() != null) {
            existingUser.setStatus(patchUser.getStatus());
        }

        return userService.save(existingUser);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        User tempUser = userService.findById(userId);
        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }
}