package com.ssg.meowwms.mapper.User;

import com.ssg.meowwms.domain.User.UserVO;
import com.ssg.meowwms.mapper.User.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@SpringBootTest
class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    void insertUser() {
        UserVO userVO = UserVO.builder()
                .uid("makeum")
                .uname("이맑음")
                .birth(LocalDate.parse("1998-12-25"))
                .upw("makeum")
                .email("makeum@test.com")
                .tel("01011112222")
                .build();
        userMapper.insertUser(userVO);
        log.info("----userVO-----" + userVO);
    }

    @Test
    void updateStatus() {
        UserVO userVO = UserVO.builder()
                .uid("makeum")
                .sid(1)
                .rid(3)
                .upw("updatePw")
                .tel("01011114444")
                .email("updateEmail@test.com")
                .build();
        userMapper.updateStatus(userVO);
    }

    @Test
    void selectUser() {
        String uid = "user2";
        UserVO userVO = userMapper.selectUser(uid);
        log.info(userVO);
    }

    @Test
    void selectAll() {
        Integer rid = null;
        List<UserVO> userVOList = userMapper.selectAll(rid);
        userVOList.forEach(log::info);
    }

    @Test
    void searchId() {
        String uname = "이맑음";
        String email = "updateEmail@test.com";
        String uid = userMapper.searchId(uname, email);
        log.info(uid);
    }

    @Test
    void searchPw() {
        String uname = "이맑음";
        String uid = "makeum";
        String upw = userMapper.searchPw(uname, uid);
        log.info(upw);
    }
}