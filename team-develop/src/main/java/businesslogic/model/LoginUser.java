package businesslogic.model;

public class LoginUser {
    private final Employee employee;

    public LoginUser(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
