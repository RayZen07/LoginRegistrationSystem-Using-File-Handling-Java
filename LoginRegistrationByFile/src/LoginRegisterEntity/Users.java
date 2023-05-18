package LoginRegisterEntity;

public class Users {
    private String username, password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
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

    @Override
    public String toString() {
        return
                "UserName=" + username +
                        "\nPassword=" + password;
    }
}
