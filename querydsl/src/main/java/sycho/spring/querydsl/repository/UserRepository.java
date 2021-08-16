package sycho.spring.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sycho.spring.querydsl.repository.custom.UserCustomRepository;
import sycho.spring.querydsl.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>, UserCustomRepository {
}
