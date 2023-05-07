package com.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/api/hello")
    public List<String> Hello(){
        ArrayList list = new ArrayList();
        list.add(0,"프론트 김민정누나");
        list.add(1,"백엔드 안진석");

        return list;
    }
}
