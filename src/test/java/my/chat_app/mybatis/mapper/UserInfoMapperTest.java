package my.chat_app.mybatis.mapper;

import lombok.extern.log4j.Log4j2;
import my.chat_app.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
class UserInfoMapperTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    void selectByPk() {
        UserInfo result = userInfoMapper.selectByPk(1);
        log.info(result);
    }

    @Test
    void selectByCondition() {
        List<UserInfo> result = userInfoMapper.selectByCondition(2);
        result.forEach(row -> log.info(row));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("강성모");
        userInfo.setPassword("123456");
        int  result= userInfoMapper.insert(userInfo);
    }

}