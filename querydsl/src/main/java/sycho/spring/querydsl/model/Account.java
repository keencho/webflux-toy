package sycho.spring.querydsl.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String loginId;
    private String password;

    @Builder
    public Account(String name, int age, String loginId, String password) {
        this.name = name;
        this.age = age;
        this.loginId = loginId;
        this.password = password;
    }
}
