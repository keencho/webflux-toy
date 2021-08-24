package sycho.spring.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sycho.spring.basic.model.Account;
import sycho.spring.basic.repository.AccountRepository;

import java.util.UUID;

@Service
public class TransactionalRollbackTestChildService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAccountAndThrowException() {
        accountRepository.save(
                Account.builder()
                        .name("이름")
                        .loginId("로그인 ID")
                        .age(30)
                        .password(UUID.randomUUID().toString())
                        .build()
        );

        throw new RuntimeException("예외 던지기");
    }
}
