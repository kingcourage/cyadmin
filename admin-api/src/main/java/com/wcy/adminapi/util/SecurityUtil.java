package com.wcy.adminapi.util;

import com.wcy.adminapi.model.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public class SecurityUtil {
    public static UserDetailsImpl getCurrentUser(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
    public static String getCurrentUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        if (principal instanceof Principal) {
            return ((Principal) principal).getName();
        }
        return String.valueOf(principal);
    }
}
