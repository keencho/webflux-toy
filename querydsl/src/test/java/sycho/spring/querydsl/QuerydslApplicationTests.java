package sycho.spring.querydsl;

import com.mysema.commons.lang.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sycho.spring.querydsl.model.User;
import sycho.spring.querydsl.repository.UserRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void Test1() {

//        Random random = new Random();
//
//        IntStream.range(1, 101).forEach(i -> userRepository.save(
//                User.builder()
//                        .name("name" + i)
//                        .age(random.nextInt(80 - 20 + 1) + 20)
//                        .loginId("id" + i)
//                        .password("pw" + i)
//                        .build()
//        ));
//
//        List<Object> getUserDTO = userRepository.listAll("FIELDS");
//
//        Assert.isTrue(getUserDTO.size() == 1, "사이즈가 1이 아니네요");

    }
}
