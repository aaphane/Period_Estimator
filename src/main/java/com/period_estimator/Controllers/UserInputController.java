package com.period_estimator.Controllers;

import com.period_estimator.Models.UserInputModel;
import com.period_estimator.Services.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInputController {

    @Autowired
    private UserInputService userInputService;

    @RequestMapping(method = RequestMethod.POST, value = "/periodestimator")
    public void addUserData(@RequestBody UserInputModel userData) {
        System.out.println("Test Controller Method(addUserData)...");
        userInputService.addUserData(userData);
    }

//    @RequestMapping("/periodestimator/{userID}")
//    public UserInputModel getUserData(@PathVariable int userID) {
//        System.out.println("Test Controller Method(getUserData)...");
//        return userInputService.getUserData(userID);
//    }

    public void updateUserData(UserInputModel userData) {
        //query database to update userData
//        userInputService.updateUserData();
    }

    public void deleteUserData(int userID) {
        //query database to delete userData
//        userInputService.deleteUserData();
    }
}
