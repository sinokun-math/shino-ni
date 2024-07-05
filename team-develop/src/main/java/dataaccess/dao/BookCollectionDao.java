package dataaccess.dao;

import dataaccess.dao.fields.BookCollectionField;
import dataaccess.dao.repository.BookCollectionRepository;
import dataaccess.dao.util.DatabaseConnection;
import dataaccess.entity.BookCollectionEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookCollectionDao implements BookCollectionRepository {

	private final QueryExecutor queryExecutor;
	private final BookCollectionRowMapper bookCollectionRowMapper;

	public BookCollectionDao(DatabaseConnection databaseConndection) {
		this.queryExecutor = new QueryExecutor(databaseConndection);
		this.bookCollectionRowMapper = new BookCollectionRowMapper();
	}

	@Override
	public void save(BookCollectionEntity entity) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(BookCollectionField.TABLE.getFieldName()).append(" (");

		sql.append(BookCollectionField.ISBN.getFieldName()).append(", ");
		sql.append(BookCollectionField.BOOK_NAME.getFieldName()).append(", ");
		sql.append(BookCollectionField.BOOK_KANA.getFieldName()).append(", ");
		sql.append(BookCollectionField.PUBLISHER.getFieldName()).append(", ");
		sql.append(BookCollectionField.NOTE.getFieldName()).append(", ");
		sql.append(BookCollectionField.LENDING_FLAG.getFieldName()).append(", ");
		sql.append(BookCollectionField.UPDATER_ID.getFieldName()).append(", ");
		sql.append(BookCollectionField.UPDATE_DATE.getFieldName()).append(") ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )");

		queryExecutor.executeQuery(connection -> {

			ParameterMapper mapper = new ParameterMapper();
			mapper.addParameter(1, entity.getIsbn());
			mapper.addParameter(2, entity.getNmBook());
			mapper.addParameter(3, entity.getKnBook());
			mapper.addParameter(4, entity.getKnBook());
			mapper.addParameter(5, entity.getNote());
			mapper.addParameter(6, entity.getFlgLending());
			mapper.addParameter(7, entity.getIdUpdate());
			mapper.addParameter(8, entity.getDateUpdate());

			PreparedStatement statement = StatementPreparer.prepareStatement(connection, sql.toString(), mapper);

			statement.executeUpdate();
			return null;
		});
	}

	@Override
    public List<BookCollectionEntity> findAll() throws SQLException {
        List<BookCollectionEntity> books = new ArrayList<>();
        StringBuilder sql = new StringBuilder(); 
        sql.append("SELECT * FROM ").append(BookCollectionField.TABLE.getFieldName());

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

	public List<BookCollectionEntity> searchBooks(String nmBook, String publisher, String note) {
		List<BookCollectionEntity> books = new ArrayList<>();
		String sql = "SELECT * FROM book_collection WHERE 1=1";
		List<Object> params = new ArrayList<>();

		if (nmBook != null && !nmBook.isEmpty()) {
			sql += " AND nm_book LIKE ?";
			params.add("%" + nmBook + "%");
		}
		if (publisher != null && !publisher.isEmpty()) {
			sql += " AND publisher LIKE ?";
			params.add("%" + publisher + "%");
		}
		if (note != null && !note.isEmpty()) {
			sql += " AND note LIKE ?";
			params.add("%" + note + "%");
		}

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			DatabaseConnection.setStatementParameter(preparedStatement, params);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					books.add(BookCollectionEntity.convertFrom(resultSet));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void insert(BookCollectionEntity book) throws SQLException {
		String query = "INSERT INTO book_collection (isbn, nm_book, kn_book, publisher, note, flg_lending, id_update, date_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			List<Object> params = Arrays.asList(book.getIsbn(), book.getNmBook(), book.getKnBook(), book.getPublisher(),
					book.getNote(), String.valueOf(book.getFlgLending()), book.getIdUpdate(), book.getDateUpdate());

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

			List<Object> params = Arrays.asList(book.getIsbn(), book.getNmBook(), book.getKnBook(), book.getPublisher(),
					book.getNote(), String.valueOf(book.getFlgLending()), book.getIdUpdate(), book.getDateUpdate(),
					book.getIdBook());

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
