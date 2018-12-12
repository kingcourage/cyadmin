package com.wcy.adminapi.model;

import com.wcy.adminapi.service.RoleService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String username;
    private String password;

    private List<Role> roles;

    @Autowired
    private RoleService roleService;


    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
    }

    public UserDetailsImpl(User user,List<Role> roles) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
