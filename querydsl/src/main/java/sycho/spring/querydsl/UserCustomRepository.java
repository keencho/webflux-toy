package sycho.spring.querydsl;

import com.querydsl.core.Tuple;

import java.util.List;

public interface UserCustomRepository {
    List<UserDTO> listAllWithoutId();
}
