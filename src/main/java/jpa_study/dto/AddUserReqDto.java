package jpa_study.dto;

import jpa_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AddUserReqDto {
    private String username;
    private String password;
    private String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .createDt(LocalDateTime.now())
                .build();
    }
}
