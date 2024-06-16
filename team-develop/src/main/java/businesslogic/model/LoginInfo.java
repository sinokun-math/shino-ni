package businesslogic.model;

public class LoginInfo {
    private final String mailAddress;
    private final String password;

    public LoginInfo(String mailAddress, String password) {
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPassword() {
        return password;
    }
}
