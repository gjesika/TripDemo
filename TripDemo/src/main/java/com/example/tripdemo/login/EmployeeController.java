package com.example.tripdemo.login;
import com.example.tripdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService ;

    @PostMapping("/register-employee")
   public String registerEmployee(@RequestParam String username,@RequestParam String password) {

      return  employeeService.addEmployee(username,password);

   }

   @PostMapping("/aprove-request")
   public String aproveRequest(@RequestParam Long id){

        return employeeService.approveRequest(id) ;

   }


}
