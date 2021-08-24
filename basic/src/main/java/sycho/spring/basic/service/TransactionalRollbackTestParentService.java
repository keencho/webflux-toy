package sycho.spring.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sycho.spring.basic.model.Account;
import sycho.spring.basic.repository.AccountRepository;

import java.util.UUID;

@Service
@Slf4j
public class TransactionalRollbackTestParentService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionalRollbackTestChildService transactionalRollbackTestChildService;

    @Transactional
    public void saveAccountWithException() {
        try {
            transactionalRollbackTestChildService.saveAccountAndThrowException();
        } catch (Exception ex) {
            log.error("내부 서비스에서 계정 생성중 에러 발생 - " + ex.getMessage());
        }

        accountRepository.save(
                Account.builder()
                        .name("테스트 이름")
                        .loginId("테스트 ID")
                        .age(20)
                        .password(UUID.randomUUID().toString())
                        .build()
        );

        log.info("계정 생성 완료");
    }
}
