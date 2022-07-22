package com.afisha.user_service.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRegistration {

    @NotBlank
    private String mail;
    @NotBlank
    private String nick;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")
    private String password;

    public UserRegistration() {
    }

    public UserRegistration(String mail, String nick, String password) {
        this.mail = mail;
        this.nick = nick;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
