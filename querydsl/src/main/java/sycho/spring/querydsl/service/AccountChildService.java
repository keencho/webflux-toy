package sycho.spring.querydsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sycho.spring.querydsl.exception.CustomException;
import sycho.spring.querydsl.model.Account;
import sycho.spring.querydsl.repository.AccountRepository;

import javax.transaction.Transactional;

@Service
public class AccountChildService {

    @Autowired
    AccountRepository accountRepository;

//    @Transactional(dontRollbackOn = CustomException.class)
    @Transactional
    public void saveAccountAndThrowException() {
        accountRepository.save(
                Account.builder()
                        .name("이름")
                        .age(26)
                        .loginId("id")
                        .password("pw")
                        .build()
        );

        throw new CustomException("throw new runtimeException on child");
    }
}
