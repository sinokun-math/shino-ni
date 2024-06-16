package dataaccess.dao;

import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BookCollectionEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookCollectionDao {

    public List<BookCollectionEntity> findAll() throws SQLException {
        List<BookCollectionEntity> books = new ArrayList<>();
        String query = "SELECT * FROM book_collection";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                books.add(BookCollectionEntity.convertFrom(rs));
            }
        }

        return books;
    }

    public BookCollectionEntity findById(int idBook) throws SQLException {
        String query = "SELECT * FROM book_collection WHERE id_book = ?";
        BookCollectionEntity book = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            DatabaseConnection.setStatementParameter(pstmt, Arrays.asList(idBook));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    book = BookCollectionEntity.convertFrom(rs);
                }
            }
        }

        return book;
    }

    public void insert(BookCollectionEntity book) throws SQLException {
        String query = "INSERT INTO book_collection (isbn, nm_book, kn_book, publisher, note, flg_lending, id_update, date_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            List<Object> params = Arrays.asList(
                    book.getIsbn(),
                    book.getNmBook(),
                    book.getKnBook(),
                    book.getPublisher(),
                    book.getNote(),
                    String.valueOf(book.getFlgLending()),
                    book.getIdUpdate(),
                    book.getDateUpdate()
            );

            DatabaseConnection.setStatementParameter(pstmt, params);
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setIdBook(generatedKeys.getInt(1));
                }
            }
        }
    }

    public void update(BookCollectionEntity book) throws SQLException {
        String query = "UPDATE book_collection SET isbn = ?, nm_book = ?, kn_book = ?, publisher = ?, note = ?, flg_lending = ?, id_update = ?, date_update = ? WHERE id_book = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            List<Object> params = Arrays.asList(
                    book.getIsbn(),
                    book.getNmBook(),
                    book.getKnBook(),
                    book.getPublisher(),
                    book.getNote(),
                    String.valueOf(book.getFlgLending()),
                    book.getIdUpdate(),
                    book.getDateUpdate(),
                    book.getIdBook()
            );

            DatabaseConnection.setStatementParameter(pstmt, params);
            pstmt.executeUpdate();
        }
    }

    public void delete(int idBook) throws SQLException {
        String query = "DELETE FROM book_collection WHERE id_book = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            DatabaseConnection.setStatementParameter(pstmt, Arrays.asList(idBook));
            pstmt.executeUpdate();
        }
    }
}
