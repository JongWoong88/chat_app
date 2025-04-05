package my.chat_app.view;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("nickname") == null) {
            log.warn("로그인하지 않은 사용자의 접근");
            return REDIRECT_URL_PREFIX + "/login";
        }

        return "view/index";
    }

}


