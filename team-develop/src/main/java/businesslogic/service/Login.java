package businesslogic.service;

import businesslogic.model.LoginInfo;
import businesslogic.model.LoginUser;
import dataaccess.dao.EmployeeDao;
import dataaccess.entity.EmployeeEntity;

public class Login {
    private EmployeeDao employeeDao = new EmployeeDao();

    public LoginUser authenticate(LoginInfo loginInfo) {
        EmployeeEntity employeeEntity = employeeDao.findByMailAddressAndPassword(loginInfo.getMailAddress(), loginInfo.getPassword());
        if (employeeEntity != null) {
            return new LoginUser(EmployeeEntity.createEmployee(employeeEntity));
        }
        return null;
    }
}
