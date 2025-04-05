package my.chat_app.mybatis.mapper;

import lombok.extern.log4j.Log4j2;
import my.chat_app.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
class UserInfoMapperTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("fiveeyes11@gmail.com");
        userInfo.setNickname("쿵쿠쿵");
        userInfo.setPassword("test1234");
        userInfo.setValid(true);
        userInfo.setRegDt(LocalDateTime.now());
        userInfoMapper.insert(userInfo);
    }

    @Test
    void select() {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        log.info(userInfo.toString());
    }
}