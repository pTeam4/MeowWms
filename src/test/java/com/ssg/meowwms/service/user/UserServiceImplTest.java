package com.ssg.meowwms.service.user;

import com.ssg.meowwms.dto.user.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Log4j2
@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void register() {
        UserDTO userDTO = UserDTO.builder()
                .uid("makeum4")
                .uname("이맑음")
                .birth(LocalDate.parse("1998-12-25"))
                .upw("makeum")
                .email("makeum@test.com")
                .tel("01011112222")
                .build();
        userService.register(userDTO);
        log.info("----userDTO-----" + userDTO);
    }

    @Test
    void modify() {
    }

    @Test
    void getOne() {
    }

    @Test
    void getList() {
    }

    @Test
    void searchId() {
    }

    @Test
    void searchPw() {
    }
}