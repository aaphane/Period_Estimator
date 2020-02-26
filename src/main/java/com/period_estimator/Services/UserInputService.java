package com.period_estimator.Services;

import com.period_estimator.Models.UserRepository;
import com.period_estimator.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserInputService {

    @Autowired
    private UserRepository userRepository;

    public String addUserData(Map<String, Object> userData) {
        //get user input
        String username = (String) userData.get("username");
        String email = (String) userData.get("email");
        String password = (String) userData.get("password"); //encrypt before saving

        //
        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        System.out.println("Test Service Method(addUserData)...  " + userData);
        return "saved";
    }

//    public UserModel getUserData(int userID) {
//        //query database to get userData
//        System.out.println("Test Service Method(getUserData)... " + userID);
//        return input;
//    }

//    public void updateUserData(UserModel userData) {
//        //query database to update userData
//    }

//    public void deleteUserData(int userID) {
//        //query database to delete userData
//    }
}
