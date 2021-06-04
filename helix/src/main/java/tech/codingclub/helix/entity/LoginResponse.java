package tech.codingclub.helix.entity;

public class LoginResponse {
    public Long id;
    public boolean is_logged_in;
    public String message;

    public LoginResponse() {
    }

    public LoginResponse(Long id, boolean is_logged_in, String message) {
        this.id = id;
        this.is_logged_in = is_logged_in;
        this.message = message;
    }
}
