package sycho.spring.querydsl;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Setter;
import sycho.spring.querydsl.queryprojectionbuilder.QueryProjectionBuilder;

@Setter
//@Service
@QueryProjectionBuilder
public class UserDTO {
    private String name;
    private int age;
    private String loginId;
    private String password;

    @QueryProjection
    @QueryProjectionBuilder
    public UserDTO(String name, int age, String loginId, String password) {
        this.name = name;
        this.age = age;
        this.loginId = loginId;
        this.password = password;
    }

//    private UserDTO(QUserDTOBuilder qUserDTOBuilder) {
//        this
//    }

//    public static class QUserDTOBuilder {
//        private String name;
//        private int age;
//        private String loginId;
//        private String password;
//
//        public QUserDTOBuilder(String name, int age, String loginId, String password) {
//            this.name = name;
//            this.age = age;
//            this.loginId = loginId;
//            this.password = password;
//        }
//
//        public UserDTO build() {
//            return new UserDTO(this);
//        }
//    }
}
