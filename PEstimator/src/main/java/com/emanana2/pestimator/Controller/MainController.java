package com.emanana2.pestimator.Controller;

import com.emanana2.pestimator.DBConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    public DBConnect connect;

    @GetMapping("/") //index endpoint.
    public String home() {
       connect.excuteQuery("INSERT INTO `user_info` (`name`, `user_id`) VALUES ('BOSS1', '6198')");
        return("home");
    }

    //registration

    //login

    //main page
}
