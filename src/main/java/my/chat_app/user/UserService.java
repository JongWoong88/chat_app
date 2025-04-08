package my.chat_app.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import my.chat_app.mybatis.mapper.UserInfoMapper;
import my.chat_app.mybatis.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    private final UserInfoMapper userInfoMapper;

    public void saveUser(String nickname, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname(nickname);
        userInfo.setPassword(password);
        userInfoMapper.insert(userInfo);
        log.info("데이터 insert 완료");
    }
}
