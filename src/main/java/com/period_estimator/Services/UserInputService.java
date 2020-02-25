package com.period_estimator.Services;

import com.period_estimator.Models.UserInputModel;
import org.springframework.stereotype.Service;

@Service
public class UserInputService {

    public void addUserData(UserInputModel userData) {
        //save userData in the database
        //call periodEstimatorService.estimateNextPeriod(userData) method;
        System.out.println("Test Service Method(addUserData)...  " + userData);
    }

//    public UserInputModel getUserData(int userID) {
//        //query database to get userData
//        System.out.println("Test Service Method(getUserData)... " + userID);
//        return input;
//    }

    public void updateUserData(UserInputModel userData) {
        //query database to update userData
    }

    public void deleteUserData(int userID) {
        //query database to delete userData
    }
}
