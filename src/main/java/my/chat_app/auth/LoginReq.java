package my.chat_app.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginReq (
        @NotBlank String email,
        @NotBlank String password
){}
