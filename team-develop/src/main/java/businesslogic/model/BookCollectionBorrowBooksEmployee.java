package businesslogic.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BookCollectionBorrowBooksEmployee {
    private final int idRequest;
    private final int idApplicant;
    private final int idBook;
    private final Date dateRequest;
    private final char status;
    private final Integer idApproval; // Allow null
    private final Date dateApproval; // Allow null
    private final Date dateBorrow;
    private final Date dateScheduledReturn;
    private final Date dateReturn; // Allow null
    private final int idUpdate;
    private final Timestamp dateUpdate;
    private final String nmEmployee;
    private final String nmBook;

    public BookCollectionBorrowBooksEmployee(int idRequest, int idApplicant, int idBook, Date dateRequest, char status, Integer idApproval, Date dateApproval, Date dateBorrow, Date dateScheduledReturn, Date dateReturn, int idUpdate, Timestamp dateUpdate, String nmEmployee, String nmBook) {
        this.idRequest = idRequest;
        this.idApplicant = idApplicant;
        this.idBook = idBook;
        this.dateRequest = dateRequest;
        this.status = status;
        this.idApproval = idApproval;
        this.dateApproval = dateApproval;
        this.dateBorrow = dateBorrow;
        this.dateScheduledReturn = dateScheduledReturn;
        this.dateReturn = dateReturn;
        this.idUpdate = idUpdate;
        this.dateUpdate = dateUpdate;
        this.nmEmployee = nmEmployee;
        this.nmBook = nmBook;
    }

    // Getters
    public int getIdRequest() { return idRequest; }
    public int getIdApplicant() { return idApplicant; }
    public int getIdBook() { return idBook; }
    public Date getDateRequest() { return dateRequest; }
    public char getStatus() { return status; }
    public Integer getIdApproval() { return idApproval; }
    public Date getDateApproval() { return dateApproval; }
    public Date getDateBorrow() { return dateBorrow; }
    public Date getDateScheduledReturn() { return dateScheduledReturn; }
    public Date getDateReturn() { return dateReturn; }
    public int getIdUpdate() { return idUpdate; }
    public Timestamp getDateUpdate() { return dateUpdate; }
    public String getNmEmployee() { return nmEmployee; }
    public String getNmBook() { return nmBook; }
}
