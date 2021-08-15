package sycho.spring.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static sycho.spring.querydsl.QUser.user;

public class UserCustomRepositoryImpl implements UserCustomRepository{

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserDTO> listAllWithoutId() {
        return jpaQueryFactory
                .select(
                        new QUserDTO(
                                user.name,
                                user.age,
                                user.loginId,
                                user.password
                        )
                )
                .from(user)
                .fetch();
    }
}
