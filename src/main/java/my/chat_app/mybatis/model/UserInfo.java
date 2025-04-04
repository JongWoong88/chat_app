package my.chat_app.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserInfo {
    private Integer       seq;
    private String        email;
    private String        password;
    private boolean       valid;
    private LocalDateTime regDt;
}
