package sycho.spring.querydsl.repository.custom;

import org.springframework.stereotype.Repository;
import sycho.spring.querydsl.dto.UserDTO;

import java.util.List;

public interface UserCustomRepository {
    List<Object> listAll(String type);
}
