package my.chat_app.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserInfo {
    private Integer id;
    private String nickname;
    private String password;
    private LocalDateTime regDt;
}
