package presentation.form;

import businesslogic.model.LoginUser;

public class LoginUserForm {
    private final String mailAddress;
    private final boolean isAdmin;

    public LoginUserForm(String mailAddress, boolean isAdmin) {
        this.mailAddress = mailAddress;
        this.isAdmin = isAdmin;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static LoginUserForm convertFrom(LoginUser model) {
        return new LoginUserForm(model.getEmployee().getMailAddress(), model.getEmployee().getFlgAdmin() == 'Y');
    }
}
