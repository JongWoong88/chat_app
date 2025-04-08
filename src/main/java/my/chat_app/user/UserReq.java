package my.chat_app.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReq {
    private String nickname;
    private String password;
}
