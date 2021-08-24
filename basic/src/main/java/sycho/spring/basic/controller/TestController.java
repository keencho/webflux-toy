package sycho.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sycho.spring.basic.service.TransactionalRollbackTestParentService;

@RestController
public class TestController {

    @Autowired
    TransactionalRollbackTestParentService transactionalRollbackTestParentService;

    @GetMapping("/test")
    public ResponseEntity test() {
        transactionalRollbackTestParentService.saveAccountWithException();

        return ResponseEntity.ok().build();
    }
}
