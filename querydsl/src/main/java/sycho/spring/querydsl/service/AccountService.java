package sycho.spring.querydsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    AccountChildService accountChildService;

    @Transactional
    public void saveAccountWithException() {
        try {
            accountChildService.saveAccountAndThrowException();
        } catch (Exception ex) {
            System.out.println("error occur on child");
        }

        System.out.println("business logic is on...");
    }
}
