package my.chat_app.mybatis.mapper;

import my.chat_app.mybatis.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    int insert(UserInfo record);
    UserInfo selectByPrimaryKey(Integer seq);
    UserInfo selectByEmail(String email);
}

