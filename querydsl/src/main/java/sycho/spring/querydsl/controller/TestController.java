package sycho.spring.querydsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sycho.spring.querydsl.service.AccountService;

@RestController
public class TestController {

    @Autowired
    AccountService accountService;

    @GetMapping("/test")
    public ResponseEntity test() {

        accountService.saveAccountWithException();

        return ResponseEntity.ok().build();
    }
}
