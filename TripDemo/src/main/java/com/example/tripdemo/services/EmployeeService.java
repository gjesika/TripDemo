package com.example.tripdemo.services;
import com.example.tripdemo.database.entities.Employee;
import com.example.tripdemo.database.repository.EmployeeRepository;
import com.example.tripdemo.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String addEmployee(String username ,String password) {
        if(employeeRepository.findByUsername(username).isPresent()){
            return "Username exists" ;
        }
         else {
            Employee employee=new Employee();
            employee.setUsername(username);
            employee.setPassword(password);
            employee.setRole(Role.ROLE_ADMIN);
            employee.setEnabled(true);
            employeeRepository.save(employee);
            return "Employee added " ;
        }


    }


    public String approveRequest(Long Id){

       Optional<Employee> employee = employeeRepository.findById(Id);

       if(employee.isPresent()){

           Employee existingEmployee = employee.get();
           existingEmployee.setEnabled(true);
           employeeRepository.save(existingEmployee);
           return "User Activated" ;
       }
       else return "User Does Not Exists " ;


    }





}
