package sneha.programming.todoapp.request;

public class AddUserRequest {
private String username;
private String password;

    public AddUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AddUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
