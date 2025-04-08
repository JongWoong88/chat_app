package my.chat_app.mybatis.mapper;

import my.chat_app.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    UserInfo selectByPk(@Param("pk") int pk);

    List<UserInfo> selectByCondition(@Param("pk") int pk);

    int insert(UserInfo userInfo);
}
