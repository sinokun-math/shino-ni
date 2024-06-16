package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BookCollectionBorrowBooksEmployeeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCollectionBorrowBooksEmployeeDao {

    public List<BookCollectionBorrowBooksEmployeeEntity> findAll() {
        List<BookCollectionBorrowBooksEmployeeEntity> applications = new ArrayList<>();
        String sql = "SELECT bb.id_request, e.nm_employee, bc.isbn, bc.nm_book, bc.publisher, bc.note, bb.date_request, bb.date_borrow, bb.date_scheduled_return, bb.status, bb.id_approval, bb.date_approval, bb.date_return, bb.id_update, bb.date_update " +
                     "FROM borrow_books bb " +
                     "JOIN employee e ON bb.id_applicant = e.id_employee " +
                     "JOIN book_collection bc ON bb.id_book = bc.id_book";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                applications.add(BookCollectionBorrowBooksEmployeeEntity.convertFrom(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public BookCollectionBorrowBooksEmployeeEntity findById(int idRequest) {
        String sql = "SELECT bb.id_request, e.nm_employee, bc.isbn, bc.nm_book, bc.publisher, bc.note, bb.date_request, bb.date_borrow, bb.date_scheduled_return, bb.status, bb.id_approval, bb.date_approval, bb.date_return, bb.id_update, bb.date_update " +
                     "FROM borrow_books bb " +
                     "JOIN employee e ON bb.id_applicant = e.id_employee " +
                     "JOIN book_collection bc ON bb.id_book = bc.id_book " +
                     "WHERE bb.id_request = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idRequest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return BookCollectionBorrowBooksEmployeeEntity.convertFrom(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
