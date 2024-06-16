package businesslogic.service;

import businesslogic.model.BookCollection;
import dataaccess.dao.BookCollectionDao;
import dataaccess.entity.BookCollectionEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookCollectionDao bookCollectionDao = new BookCollectionDao();

    public List<BookCollection> searchBooks(String nmBook, String publisher, String note) {
        List<BookCollectionEntity> entities = bookCollectionDao.searchBooks(nmBook, publisher, note);
        return entities.stream().map(BookCollectionEntity::toModel).collect(Collectors.toList());
    }

    public BookCollection getBookById(int idBook) throws SQLException {
        BookCollectionEntity entity = bookCollectionDao.findById(idBook);
        return entity != null ? entity.toModel() : null;
    }

    public void registerBook(BookCollection book) throws SQLException {
        BookCollectionEntity entity = BookCollectionEntity.convertFrom(book);
        bookCollectionDao.insert(entity);
    }

    public void updateBook(BookCollection book) throws SQLException {
        BookCollectionEntity entity = BookCollectionEntity.convertFrom(book);
        bookCollectionDao.update(entity);
    }
}
