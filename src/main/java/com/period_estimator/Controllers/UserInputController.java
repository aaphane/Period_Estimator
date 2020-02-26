package com.period_estimator.Controllers;

import com.period_estimator.Models.Users;
import com.period_estimator.Services.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserInputController {

    @Autowired
    private UserInputService userInputService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String addUserData(@RequestBody Map<String, Object> userData) {
        System.out.println("Test Controller Method(addUserData)..." + userData.get("username"));
        return userInputService.addUserData(userData);
    }

//    @RequestMapping("/periodestimator/{userID}")
//    public UserModel getUserData(@PathVariable int userID) {
//        System.out.println("Test Controller Method(getUserData)...");
//        return userInputService.getUserData(userID);
//    }

    public void updateUserData(Users userData) {
        //query database to update userData
//        userInputService.updateUserData();
    }

    public void deleteUserData(int userID) {
        //query database to delete userData
//        userInputService.deleteUserData();
    }
}
