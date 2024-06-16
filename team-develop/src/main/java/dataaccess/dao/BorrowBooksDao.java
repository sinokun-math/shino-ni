package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BorrowBooksEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BorrowBooksDao {

    public List<BorrowBooksEntity> findAll() throws SQLException {
        List<BorrowBooksEntity> borrowBooks = new ArrayList<>();
        String sql = "SELECT * FROM borrow_books";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                borrowBooks.add(BorrowBooksEntity.convertFrom(resultSet));
            }
        }

        return borrowBooks;
    }

    public BorrowBooksEntity findById(int idRequest) throws SQLException {
        String sql = "SELECT * FROM borrow_books WHERE id_request = ?";
        BorrowBooksEntity borrowBooks = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, Arrays.asList(idRequest));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    borrowBooks = BorrowBooksEntity.convertFrom(resultSet);
                }
            }
        }

        return borrowBooks;
    }

    public void insert(BorrowBooksEntity borrowBooks) throws SQLException {
        String sql = "INSERT INTO borrow_books (id_applicant, id_book, date_request, status, id_approval, date_approval, date_borrow, date_scheduled_return, date_return, id_update, date_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            List<Object> params = Arrays.asList(
                    borrowBooks.getIdApplicant(),
                    borrowBooks.getIdBook(),
                    borrowBooks.getDateRequest(),
                    borrowBooks.getStatus(),
                    borrowBooks.getIdApproval(),
                    borrowBooks.getDateApproval(),
                    borrowBooks.getDateBorrow(),
                    borrowBooks.getDateScheduledReturn(),
                    borrowBooks.getDateReturn(),
                    borrowBooks.getIdUpdate(),
                    borrowBooks.getDateUpdate()
            );

            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    borrowBooks.setIdRequest(generatedKeys.getInt(1));
                }
            }
        }
    }

    public void update(BorrowBooksEntity borrowBooks) throws SQLException {
        String sql = "UPDATE borrow_books SET id_applicant = ?, id_book = ?, date_request = ?, status = ?, id_approval = ?, date_approval = ?, date_borrow = ?, date_scheduled_return = ?, date_return = ?, id_update = ?, date_update = ? WHERE id_request = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = Arrays.asList(
                    borrowBooks.getIdApplicant(),
                    borrowBooks.getIdBook(),
                    borrowBooks.getDateRequest(),
                    borrowBooks.getStatus(),
                    borrowBooks.getIdApproval(),
                    borrowBooks.getDateApproval(),
                    borrowBooks.getDateBorrow(),
                    borrowBooks.getDateScheduledReturn(),
                    borrowBooks.getDateReturn(),
                    borrowBooks.getIdUpdate(),
                    borrowBooks.getDateUpdate(),
                    borrowBooks.getIdRequest()
            );

            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int idRequest) throws SQLException {
        String sql = "DELETE FROM borrow_books WHERE id_request = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, Arrays.asList(idRequest));
            preparedStatement.executeUpdate();
        }
    }
}
