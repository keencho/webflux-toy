package sycho.spring.querydsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/insert")
    public JsonResult insert() {
        Random random = new Random();
        return JsonResult.success(
                IntStream.range(1, 101).mapToObj(i -> userRepository.save(
                        User.builder()
                                .name("name" + i)
                                .age(random.nextInt(80 - 20 + 1) + 20)
                                .loginId("id" + i)
                                .password("pw" + i)
                                .build()
                ))
        );
    }

    @GetMapping("/list")
    public JsonResult list(
            @RequestParam(name = "withoutId", required = false) boolean withoutId
    ) {
        if (withoutId) {
            return JsonResult.success(userRepository.listAllWithoutId());
        }
        return JsonResult.success(userRepository.findAll());
    }

}
