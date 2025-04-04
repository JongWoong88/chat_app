package my.chat_app.controller;

import lombok.extern.log4j.Log4j2;
import my.chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Log4j2
public class ChatController {
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        log.info("id: {}, msg: {}", chatMessage.getSender(), chatMessage.getContent());

        return new ChatMessage(
                chatMessage.getSender(),
                chatMessage.getContent(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        );
    }
}
