package com.example.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/success")
    public String demo() {
        return "HELLO..!";
    }
}
