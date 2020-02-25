package com.emanana2.pestimator.Controller;

import com.emanana2.pestimator.DBConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    public DBConnect dbConnect;


    @GetMapping("/") //index endpoint.
    public String home() {

        DBConnect conn = new DBConnect();

        conn.query(conn.getConnection(), "SELECT * FROM test.user_info ");

        return("home");
    }

    //registration

    //login

    //main page
}
