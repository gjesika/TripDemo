package com.example.tripdemo.services;
import com.example.tripdemo.database.entities.Employee;
import com.example.tripdemo.database.repository.EmployeeRepository;
import com.example.tripdemo.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Employee employee =  employeeRepository.findByUsername(username).orElseThrow(
             ()->new UsernameNotFoundException("Not found"));
     return new UserDetailImpl(employee);
    }
}
