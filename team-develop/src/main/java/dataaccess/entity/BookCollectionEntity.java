package dataaccess.entity;

import businesslogic.model.BookCollection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollectionEntity {
    private int idBook;
    private String isbn;
    private String nmBook;
    private String knBook; // Allow null
    private String publisher; // Allow null
    private String note; // Allow null
    private char flgLending;
    private int idUpdate;
    private Timestamp dateUpdate;

    // Getters and setters
    public int getIdBook() { return idBook; }
    public void setIdBook(int idBook) { this.idBook = idBook; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getNmBook() { return nmBook; }
    public void setNmBook(String nmBook) { this.nmBook = nmBook; }

    public String getKnBook() { return knBook; }
    public void setKnBook(String knBook) { this.knBook = knBook; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public char getFlgLending() { return flgLending; }
    public void setFlgLending(char flgLending) { this.flgLending = flgLending; }

    public int getIdUpdate() { return idUpdate; }
    public void setIdUpdate(int idUpdate) { this.idUpdate = idUpdate; }

    public Timestamp getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Timestamp dateUpdate) { this.dateUpdate = dateUpdate; }

    // Convert from ResultSet
    public static BookCollectionEntity convertFrom(ResultSet resultSet) throws SQLException {
        BookCollectionEntity entity = new BookCollectionEntity();
        entity.setIdBook(resultSet.getInt("id_book"));
        entity.setIsbn(resultSet.getString("isbn"));
        entity.setNmBook(resultSet.getString("nm_book"));
        entity.setKnBook(resultSet.getString("kn_book"));
        entity.setPublisher(resultSet.getString("publisher"));
        entity.setNote(resultSet.getString("note"));
        entity.setFlgLending(resultSet.getString("flg_lending").charAt(0));
        entity.setIdUpdate(resultSet.getInt("id_update"));
        entity.setDateUpdate(resultSet.getTimestamp("date_update"));
        return entity;
    }

    // Convert from BookCollection model
    public static BookCollectionEntity convertFrom(BookCollection model) {
        return new BookCollectionEntity(
            model.getIdBook(),
            model.getIsbn(),
            model.getNmBook(),
            model.getKnBook(),
            model.getPublisher(),
            model.getNote(),
            model.getFlgLending(),
            model.getIdUpdate(),
            model.getDateUpdate()
        );
    }

    // Constructor for BookCollectionEntity
    public BookCollectionEntity(int idBook, String isbn, String nmBook, String knBook, String publisher, String note, char flgLending, int idUpdate, Timestamp dateUpdate) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.nmBook = nmBook;
        this.knBook = knBook;
        this.publisher = publisher;
        this.note = note;
        this.flgLending = flgLending;
        this.idUpdate = idUpdate;
        this.dateUpdate = dateUpdate;
    }

    // Default constructor
    public BookCollectionEntity() {}

    // Create BookCollection from BookCollectionEntity
    public static BookCollection createBookCollection(BookCollectionEntity entity) {
        return new BookCollection(
            entity.getIdBook(),
            entity.getIsbn(),
            entity.getNmBook(),
            entity.getKnBook(),
            entity.getPublisher(),
            entity.getNote(),
            entity.getFlgLending(),
            entity.getIdUpdate(),
            entity.getDateUpdate()
        );
    }

    // Create List<BookCollection> from List<BookCollectionEntity>
    public static List<BookCollection> createBookCollectionList(List<BookCollectionEntity> entities) {
        return entities.stream()
                .map(BookCollectionEntity::createBookCollection)
                .collect(Collectors.toList());
    }
}
