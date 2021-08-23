package sycho.spring.querydsl;

import com.mysema.commons.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import sycho.spring.querydsl.model.Account;
import sycho.spring.querydsl.repository.AccountRepository;
import sycho.spring.querydsl.service.AccountService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Test
    void Test1() {
        accountService.saveAccountWithException();
    }

    private void insert() {
        List<Account> accountList = accountRepository.findAll();

        if (accountList.isEmpty()) {
            Random random = new Random();

            IntStream.range(1, 101).forEach(i -> accountRepository.save(
                    Account.builder()
                            .name("name" + i)
                            .age(random.nextInt(80 - 20 + 1) + 20)
                            .loginId("id" + i)
                            .password("pw" + i)
                            .build()
            ));
        }
    }
}
