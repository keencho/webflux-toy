package sycho.spring.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Setter;
import sycho.spring.querydsl.queryprojectionbuilder.QueryProjectionBuilder;

@Setter
//@Service
@QueryProjectionBuilder
public class AccountDTO {
    private String name;
    private int age;
    private String loginId;
    private String password;

    @QueryProjection
    @QueryProjectionBuilder
    public AccountDTO(String name, int age, String loginId, String password) {
        this.name = name;
        this.age = age;
        this.loginId = loginId;
        this.password = password;
    }
}
