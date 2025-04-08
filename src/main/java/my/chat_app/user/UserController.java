package my.chat_app.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get vs Post
    // Get: 페이지 url(브라우저 주소 쓰고 엔터 치면 겟 요청), 데이터 단순 조회(select)
    // Post: insert, update, delete에 대응되는 기능들

    // Get - Query String
    // /create/user?nickname=송종웅&password=1234
    @GetMapping("/create/user")
    public String createUser(@RequestParam(required = false) String nickname,
                             @RequestParam(value = "password", required = false) String pwd) {
        log.info("nickname: {}", nickname);
        log.info("password: {}", pwd);

        if (StringUtils.isNoneBlank(nickname, pwd)) {
            userService.saveUser(nickname, pwd);
        }

        return "view/test";
    }

    // Post - Form
    @PostMapping(value = "/create/user2")
    public String createUser2(UserReq userReq) {
        log.info("nickname: {}", userReq.getNickname());
        log.info("password: {}", userReq.getPassword());

        userService.saveUser(userReq.getNickname(), userReq.getPassword());

        return "view/test";
    }

    // Post - Json Body @RequestBody

}
