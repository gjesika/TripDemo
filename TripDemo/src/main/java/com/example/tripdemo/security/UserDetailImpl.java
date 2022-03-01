package com.example.tripdemo.security;
import com.example.tripdemo.database.entities.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetailImpl implements UserDetails {

    private String username;
    private String password;
    private boolean isEnabled ;
    private List<GrantedAuthority> authorities;

    public UserDetailImpl(Employee employee) {
        this.username=employee.getUsername();
        this.password= employee.getPassword();
        this.isEnabled=employee.isEnabled();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority(employee.getRole().toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
