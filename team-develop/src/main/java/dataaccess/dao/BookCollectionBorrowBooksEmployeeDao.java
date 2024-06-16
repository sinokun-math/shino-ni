package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BookCollectionBorrowBooksEmployeeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCollectionBorrowBooksEmployeeDao {

    public List<BookCollectionBorrowBooksEmployeeEntity> findAll() throws SQLException {
        List<BookCollectionBorrowBooksEmployeeEntity> results = new ArrayList<>();
        String sql = "SELECT bb.id_request, bb.id_applicant, bb.id_book, bb.date_request, bb.status, bb.id_approval, bb.date_approval, bb.date_borrow, bb.date_scheduled_return, bb.date_return, bb.id_update, bb.date_update, e.nm_employee, b.nm_book " +
                     "FROM borrow_books bb " +
                     "JOIN employee e ON bb.id_applicant = e.id_employee " +
                     "JOIN book_collection b ON bb.id_book = b.id_book";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                results.add(BookCollectionBorrowBooksEmployeeEntity.convertFrom(resultSet));
            }
        }

        return results;
    }

    public BookCollectionBorrowBooksEmployeeEntity findById(int idRequest) throws SQLException {
        String sql = "SELECT bb.id_request, bb.id_applicant, bb.id_book, bb.date_request, bb.status, bb.id_approval, bb.date_approval, bb.date_borrow, bb.date_scheduled_return, bb.date_return, bb.id_update, bb.date_update, e.nm_employee, b.nm_book " +
                     "FROM borrow_books bb " +
                     "JOIN employee e ON bb.id_applicant = e.id_employee " +
                     "JOIN book_collection b ON bb.id_book = b.id_book " +
                     "WHERE bb.id_request = ?";
        BookCollectionBorrowBooksEmployeeEntity result = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            DatabaseConnection.setStatementParameter(preparedStatement, List.of(idRequest));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    result = BookCollectionBorrowBooksEmployeeEntity.convertFrom(resultSet);
                }
            }
        }

        return result;
    }
}
