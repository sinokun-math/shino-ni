package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BorrowBooksEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import businesslogic.model.BorrowBooks;

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

    public void insert(BorrowBooks borrowBooks) {
        String sql = "INSERT INTO borrow_books (id_applicant, id_book, date_request, status, date_borrow, date_scheduled_return, id_update, date_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = List.of(
                borrowBooks.getIdApplicant(),
                borrowBooks.getIdBook(),
                borrowBooks.getDateRequest(),
                borrowBooks.getStatus(),
                borrowBooks.getDateBorrow(),
                borrowBooks.getDateScheduledReturn(),
                borrowBooks.getIdUpdate(),
                borrowBooks.getDateUpdate()
            );

            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    
    public void updateStatus(int idRequest, char status, Integer idApproval, int idUpdate, Timestamp dateUpdate) {
        String sql = "UPDATE borrow_books SET status = ?, id_approval = ?, id_update = ?, date_update = ? WHERE id_request = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = List.of(status, idApproval, idUpdate, dateUpdate, idRequest);
            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateLendingFlag(int idRequest, char flgLending) {
        String sql = "UPDATE book_collection bc " +
                     "JOIN borrow_books bb ON bc.id_book = bb.id_book " +
                     "SET bc.flg_lending = ? " +
                     "WHERE bb.id_request = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            List<Object> params = List.of(flgLending, idRequest);
            DatabaseConnection.setStatementParameter(preparedStatement, params);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
