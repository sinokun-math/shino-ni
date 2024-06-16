package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.EmployeeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDao {

    public List<EmployeeEntity> findAll() throws SQLException {
        List<EmployeeEntity> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                employees.add(EmployeeEntity.convertFrom(resultSet));
            }
        }

        return employees;
    }

    public EmployeeEntity findById(int idEmployee) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id_employee = ?";
        EmployeeEntity employee = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, Arrays.asList(idEmployee));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = EmployeeEntity.convertFrom(resultSet);
                }
            }
        }

        return employee;
    }
    
    public EmployeeEntity findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT * FROM employee WHERE mail_address = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, Arrays.asList(mailAddress, password));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return EmployeeEntity.convertFrom(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(EmployeeEntity employee) throws SQLException {
        String sql = "INSERT INTO employee (nm_employee, kn_employee, mail_address, password, flg_admin, flg_retirement, id_update, date_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = Arrays.asList(
                    employee.getNmEmployee(),
                    employee.getKnEmployee(),
                    employee.getMailAddress(),
                    employee.getPassword(),
                    employee.getFlgAdmin(),
                    employee.getFlgRetirement(),
                    employee.getIdUpdate(),
                    employee.getDateUpdate()
            );

            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        }
    }

    public void update(EmployeeEntity employee) throws SQLException {
        String sql = "UPDATE employee SET nm_employee = ?, kn_employee = ?, mail_address = ?, password = ?, flg_admin = ?, flg_retirement = ?, id_update = ?, date_update = ? WHERE id_employee = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = Arrays.asList(
                    employee.getNmEmployee(),
                    employee.getKnEmployee(),
                    employee.getMailAddress(),
                    employee.getPassword(),
                    employee.getFlgAdmin(),
                    employee.getFlgRetirement(),
                    employee.getIdUpdate(),
                    employee.getDateUpdate(),
                    employee.getIdEmployee()
            );

            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int idEmployee) throws SQLException {
        String sql = "DELETE FROM employee WHERE id_employee = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, Arrays.asList(idEmployee));
            preparedStatement.executeUpdate();
        }
    }
}
