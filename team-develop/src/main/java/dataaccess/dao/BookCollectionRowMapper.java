package dataaccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataaccess.dao.fields.BookCollectionField;
import dataaccess.entity.BookCollectionEntity;

public class BookCollectionRowMapper {

	// Convert from ResultSet
    public static BookCollectionEntity mapRow(ResultSet resultSet) throws SQLException {
        BookCollectionEntity entity = new BookCollectionEntity();
        entity.setIdBook(resultSet.getInt(BookCollectionField.BOOK_ID.getFieldName()));
        entity.setIsbn(resultSet.getString(BookCollectionField.ISBN.getFieldName()));
        entity.setNmBook(resultSet.getString(BookCollectionField.BOOK_NAME.getFieldName()));
        entity.setKnBook(resultSet.getString(BookCollectionField.BOOK_KANA.getFieldName()));
        entity.setPublisher(resultSet.getString(BookCollectionField.PUBLISHER.getFieldName()));
        entity.setNote(resultSet.getString(BookCollectionField.NOTE.getFieldName()));
        entity.setFlgLending(resultSet.getString(BookCollectionField.LENDING_FLAG.getFieldName()).charAt(0));
        entity.setIdUpdate(resultSet.getInt(BookCollectionField.UPDATER_ID.getFieldName()));
        entity.setDateUpdate(resultSet.getTimestamp(BookCollectionField.UPDATE_DATE.getFieldName()));
        return entity;
    }
}