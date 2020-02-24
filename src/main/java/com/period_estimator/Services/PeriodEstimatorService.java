package com.period_estimator.Services;

import com.period_estimator.Models.PeriodEstimatorModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PeriodEstimatorService {

    //Testing purposes
    private PeriodEstimatorModel estimate = new PeriodEstimatorModel(1, 2020, 02, 24, 5, 5);

    public void addUserData(PeriodEstimatorModel userData) {
        //do calculation before saving data
        System.out.println("Test Service Method(addUserData)...  " + userData);
    }

    //To return estimated time
    public PeriodEstimatorModel getUserData(int userID) {
        //query database to get userData
        System.out.println("Test Controller Method(getUserData)... " + userID);
        return estimate;
    }

    public void updateUserData(PeriodEstimatorModel userData) {
        //query database to update userData
    }

    public void deleteUserData(int userID) {
        //query database to delete userData
    }
}
