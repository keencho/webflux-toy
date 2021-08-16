package sycho.spring.querydsl.repository.custom;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sycho.spring.querydsl.dto.QUserDTO;
import sycho.spring.querydsl.dto.UserDTO;

import java.util.List;

import static sycho.spring.querydsl.model.QUser.user;

public class UserCustomRepositoryImpl implements UserCustomRepository{

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Object> listAll(String type) {
        return jpaQueryFactory
                .select(getExpression(type))
                .from(user)
                .fetch();
    }

    private Expression<Object> getExpression(String type) {
        Expression<Object> userDTOExpression = null;

        switch (type.toUpperCase()) {
            case "FIELDS":
                userDTOExpression = Projections.fields(
                        UserDTO.class,
                        user.name.as("name"),
                        user.age.as("age"),
                        user.loginId.as("loginId"),
                        user.password.as("password")
                );
                break;
            default:
                break;
        }

        return userDTOExpression;
    }
}
