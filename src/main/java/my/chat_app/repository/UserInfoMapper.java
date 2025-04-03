package my.chat_app.repository;

import my.chat_app.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    int insert(UserInfo record);
    UserInfo selectByPrimaryKey(Integer seq);
}

