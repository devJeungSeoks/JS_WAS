package com.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import util.function.Util;


@Service
public class UserService {

    Util util = new Util();
    
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    Logger log = LoggerFactory.getLogger(getClass().getName());

}
