package com.period_estimator.Controllers;

import com.period_estimator.Models.PeriodEstimatorModel;
import com.period_estimator.Services.PeriodEstimatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeriodEstimatorController {

    @Autowired
    private PeriodEstimatorService periodEstimatorService;

    @RequestMapping(method = RequestMethod.POST, value = "/periodestimator")
    public void addUserData(@RequestBody PeriodEstimatorModel userData) {
        System.out.println("Test Controller Method(addUserData)...");
        periodEstimatorService.addUserData(userData);
    }

    @RequestMapping("/periodestimator/{userID}")
    public PeriodEstimatorModel getUserData(@PathVariable int userID) {
        System.out.println("Test Controller Method(getUserData)...");
        return periodEstimatorService.getUserData(userID);
    }

    public void updateUserData(PeriodEstimatorModel userData) {
        //query database to update userData
//        periodEstimatorService.updateUserData();
    }

    public void deleteUserData(int userID) {
        //query database to delete userData
//        periodEstimatorService.deleteUserData();
    }
}
