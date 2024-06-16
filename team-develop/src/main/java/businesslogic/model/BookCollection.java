package businesslogic.model;

import java.sql.Timestamp;

public class BookCollection {
    private final int idBook;
    private final String isbn;
    private final String nmBook;
    private final String knBook; // Allow null
    private final String publisher; // Allow null
    private final String note; // Allow null
    private final char flgLending;
    private final int idUpdate;
    private final Timestamp dateUpdate;

    public BookCollection(int idBook, String isbn, String nmBook, String knBook, String publisher, String note, char flgLending, int idUpdate, Timestamp dateUpdate) {
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

    // Getters
    public int getIdBook() { return idBook; }
    public String getIsbn() { return isbn; }
    public String getNmBook() { return nmBook; }
    public String getKnBook() { return knBook; }
    public String getPublisher() { return publisher; }
    public String getNote() { return note; }
    public char getFlgLending() { return flgLending; }
    public int getIdUpdate() { return idUpdate; }
    public Timestamp getDateUpdate() { return dateUpdate; }
}
