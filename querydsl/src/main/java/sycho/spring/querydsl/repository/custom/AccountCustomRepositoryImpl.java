package sycho.spring.querydsl.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountCustomRepositoryImpl implements AccountCustomRepository {

    @Autowired
    JPAQueryFactory jpaQueryFactory;
}
