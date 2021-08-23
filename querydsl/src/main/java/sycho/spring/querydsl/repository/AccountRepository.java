package sycho.spring.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sycho.spring.querydsl.model.Account;
import sycho.spring.querydsl.repository.custom.AccountCustomRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, AccountCustomRepository {
}
