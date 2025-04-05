package my.chat_app.auth;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import my.chat_app.mybatis.mapper.UserInfoMapper;
import my.chat_app.mybatis.model.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ApiLoginController {

    private final UserInfoMapper userInfoMapper;

    @PostMapping("/api/sign-in")
    public ResponseEntity<Boolean> signIn(@RequestBody @Valid LoginReq reqDTO,
                                          BindingResult bindingResult,
                                          HttpSession session) {
        log.info(reqDTO);

        if (bindingResult.hasErrors()) {
            log.warn("잘못된 요청 파라미터");
            return ResponseEntity.badRequest().body(false);
        }

        UserInfo userInfo = userInfoMapper.selectByEmail(reqDTO.email());

        if (userInfo == null || !StringUtils.equals(reqDTO.password(), userInfo.getPassword())) {
            log.warn("존재하지 않는 이메일 또는 비밀번호 불일치");
            return ResponseEntity.badRequest().body(false);
        }

        log.info("{} 로그인 성공", userInfo.getEmail());

        session.setAttribute("nickname", userInfo.getNickname());

        return ResponseEntity.ok(true);
    }

}


