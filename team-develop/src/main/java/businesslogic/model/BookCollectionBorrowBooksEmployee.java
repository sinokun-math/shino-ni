package businesslogic.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BookCollectionBorrowBooksEmployee {
    private final int idRequest;
    private final String nmEmployee;
    private final String isbn;
    private final String nmBook;
    private final String publisher;
    private final String note;
    private final Date dateRequest;
    private final Date dateBorrow;
    private final Date dateScheduledReturn;
    private final char status;
    private final Integer idApproval;
    private final Date dateApproval;
    private final Date dateReturn;
    private final int idUpdate;
    private final Timestamp dateUpdate;

    public BookCollectionBorrowBooksEmployee(int idRequest, String nmEmployee, String isbn, String nmBook, String publisher, String note, Date dateRequest, Date dateBorrow, Date dateScheduledReturn, char status, Integer idApproval, Date dateApproval, Date dateReturn, int idUpdate, Timestamp dateUpdate) {
        this.idRequest = idRequest;
        this.nmEmployee = nmEmployee;
        this.isbn = isbn;
        this.nmBook = nmBook;
        this.publisher = publisher;
        this.note = note;
        this.dateRequest = dateRequest;
        this.dateBorrow = dateBorrow;
        this.dateScheduledReturn = dateScheduledReturn;
        this.status = status;
        this.idApproval = idApproval;
        this.dateApproval = dateApproval;
        this.dateReturn = dateReturn;
        this.idUpdate = idUpdate;
        this.dateUpdate = dateUpdate;
    }

    // Getters
    public int getIdRequest() { return idRequest; }
    public String getNmEmployee() { return nmEmployee; }
    public String getIsbn() { return isbn; }
    public String getNmBook() { return nmBook; }
    public String getPublisher() { return publisher; }
    public String getNote() { return note; }
    public Date getDateRequest() { return dateRequest; }
    public Date getDateBorrow() { return dateBorrow; }
    public Date getDateScheduledReturn() { return dateScheduledReturn; }
    public char getStatus() { return status; }
    public Integer getIdApproval() { return idApproval; }
    public Date getDateApproval() { return dateApproval; }
    public Date getDateReturn() { return dateReturn; }
    public int getIdUpdate() { return idUpdate; }
    public Timestamp getDateUpdate() { return dateUpdate; }
}
