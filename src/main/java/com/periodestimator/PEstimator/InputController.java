package com.periodestimator.PEstimator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.sql.*;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

@Controller
class InputContoller {

    //validate numbers
    boolean checkInt(int someNumber){
        String temp = Integer.toString(someNumber);
        if(!temp.matches("[0-9]")) {
            return true;
        }else{
            return false;
        }
    }

    //validate alphabets
    boolean checkName(String name){
        if (name.matches("([A-Za-z])\\w+")){
            return true;
        }
        else {
            return false;
        }
    }

    @Autowired
    public DBConnect connect;

    @GetMapping("/")
    public String home() {
       // String buy = "buySome";
     // connect.excuteQueryC("INSERT INTO `pestimator`.`userinput` (`username`,`startday`, `periodlength`, `monthnum`, `cyclelength`)  VALUES ('"+buy+"', '3', '34', '2', '76')");
        return("home");
    }

	@GetMapping("/home")
	public String index(Model model) {
	  model.addAttribute("userInput", new Input());
      return "index";
    }
    
    @RestController
	public class MyController {

    @RequestMapping(value = "/sid", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

         public void getImage(HttpServletResponse response) throws IOException {

            var imgFile = new ClassPathResource("images/img5.jpg");

            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	    }
    }

//    @GetMapping("/update")
//    public String update(@ModelAttribute Input userInput, Model model) throws SQLException {
//
//        String Name = userInput.name;
//        //get connection
//        Properties info = new Properties();
//        String url;
//        url = "jdbc:mysql://localhost:3306/pestimator";
//        info.put("user", "root");
//        info.put("password", "@Siyamthanda2017");
//        Connection conn = DriverManager.getConnection(url, info);
//        //get username from database.
//        String sql = "SELECT * FROM userinput";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        ResultSet row = stmt.executeQuery(sql);
//        System.out.println(row);
//        //use username to update selected row
//
//        return "updated";
//    }



	@PostMapping("/input")
	public String result(@ModelAttribute Input userInput, Model model) {
        //user input
        String Name = userInput.name;
        int StartDay = userInput.startDate;
        int PeriodLength = userInput.periodLength;
        int MonthNum = userInput.monthNum;
        int cycleLength = userInput.cycleLength;


        //validate above and add to database.
        if (checkName(Name)){
            //add to database.
            connect.excuteQueryC("INSERT INTO `pestimator`.`userinput` (`username`,`startday`, `periodlength`, `monthnum`, `cyclelength`) " +
                    "VALUES ('"+Name+"', '"+StartDay+"', '"+PeriodLength+"', '"+MonthNum+"', '"+cycleLength+"')");
            System.out.println("test cases test");

            // days table
            int LastDay = (StartDay + PeriodLength) - 1;
            int LastDayOfPeriod = StartDay + PeriodLength;
            int OvulationStartDay = LastDayOfPeriod + 5;
            int MostFertileDay = OvulationStartDay + 2;
            int OvulationEndDay = MostFertileDay + 2;

            //dates (table)
            int NextPeriodDay = cycleLength + StartDay;
            String OvuStartDate;
            String MostFertDate;
            String OvuEndDate;
            String NextPeriodDate;
            String StartDate;
            String EndDate;

            Calendar calendar = Calendar.getInstance();
            int MonthNum2;
            int Year = calendar.getWeekYear();
            calendar.set(Year, MonthNum - 1, 1);
            int NextYear = Year + 1;
            int Days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (MonthNum == 12)
                MonthNum2 = MonthNum - 12;
            else
                MonthNum2 = MonthNum + 1;
            StartDate = StartDay + "/" + MonthNum + "/" + Year;
            if (LastDay > Days)
            {
                LastDay = LastDay - Days;
                OvulationStartDay = OvulationStartDay - Days;
                MostFertileDay = MostFertileDay - Days;
                OvulationEndDay = OvulationEndDay - Days;
                NextPeriodDay = NextPeriodDay - Days;
                if (MonthNum == 12)
                {
                    EndDate = LastDay + "/" + MonthNum2 + "/" + NextYear;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum2 + "/" + NextYear;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + NextYear;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + NextYear;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + NextYear;
                }
                else
                {
                    EndDate = LastDay + "/" + MonthNum2 + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum2 + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + Year;
                }
            }
            else if (OvulationStartDay > Days)
            {
                OvulationStartDay = OvulationStartDay - Days;
                MostFertileDay = MostFertileDay - Days;
                OvulationEndDay = OvulationEndDay - Days;
                NextPeriodDay = NextPeriodDay - Days;
                if (MonthNum == 12)
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum2 + "/" + NextYear;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + NextYear;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + NextYear;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + NextYear;
                }
                else
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum2 + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + Year;
                }
            }
            else if (MostFertileDay > Days)
            {
                MostFertileDay = MostFertileDay - Days;
                OvulationEndDay = OvulationEndDay - Days;
                NextPeriodDay = NextPeriodDay - Days;
                if (MonthNum == 12)
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + NextYear;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + NextYear;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + NextYear;
                }
                else
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum2 + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + Year;
                }
            }
            else if (OvulationEndDay > Days)
            {
                OvulationEndDay = OvulationEndDay - Days;
                NextPeriodDay = NextPeriodDay - Days;
                if (MonthNum == 12)
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + NextYear;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + NextYear;
                }
                else
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum2 + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + Year;
                }
            }
            else if (NextPeriodDay > Days)
            {
                NextPeriodDay = NextPeriodDay - Days;
                if (MonthNum == 12)
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + NextYear;
                }
                else
                {
                    EndDate = LastDay + "/" + MonthNum + "/" + Year;
                    OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                    MostFertDate = MostFertileDay + "/" + MonthNum + "/" + Year;
                    OvuEndDate = OvulationEndDay + "/" + MonthNum + "/" + Year;
                    NextPeriodDate = NextPeriodDay + "/" + MonthNum2 + "/" + Year;
                }
            }
            else
            {
                EndDate = LastDay + "/" + MonthNum + "/" + Year;
                OvuStartDate = OvulationStartDay + "/" + MonthNum + "/" + Year;
                MostFertDate = MostFertileDay + "/" + MonthNum + "/" + Year;
                OvuEndDate = OvulationEndDay + "/" + MonthNum + "/" + Year;
                NextPeriodDate = NextPeriodDay + "/" + MonthNum + "/" + Year;
            }
            model.addAttribute("Name", Name);
            model.addAttribute("PerStart", StartDate);
            model.addAttribute("PerEnd", EndDate);
            model.addAttribute("OvuStart", OvuStartDate);
            model.addAttribute("OvuEnd", OvuEndDate);
            model.addAttribute("MostFert", MostFertDate);
            model.addAttribute("NextPeriod", NextPeriodDate);
            return("output");

        }else{
            return "index";
        }


    }

    @GetMapping("/update")
    public String update(@ModelAttribute Input userInput, Model model){

        return "update";
    }

}