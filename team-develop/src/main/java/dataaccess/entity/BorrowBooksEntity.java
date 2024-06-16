package dataaccess.entity;

import businesslogic.model.BorrowBooks;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class BorrowBooksEntity {
    private int idRequest;
    private int idApplicant;
    private int idBook;
    private Date dateRequest;
    private char status;
    private Integer idApproval; // Allow null
    private Date dateApproval; // Allow null
    private Date dateBorrow;
    private Date dateScheduledReturn;
    private Date dateReturn; // Allow null
    private int idUpdate;
    private Timestamp dateUpdate;

    // Getters and setters
    public int getIdRequest() { return idRequest; }
    public void setIdRequest(int idRequest) { this.idRequest = idRequest; }

    public int getIdApplicant() { return idApplicant; }
    public void setIdApplicant(int idApplicant) { this.idApplicant = idApplicant; }

    public int getIdBook() { return idBook; }
    public void setIdBook(int idBook) { this.idBook = idBook; }

    public Date getDateRequest() { return dateRequest; }
    public void setDateRequest(Date dateRequest) { this.dateRequest = dateRequest; }

    public char getStatus() { return status; }
    public void setStatus(char status) { this.status = status; }

    public Integer getIdApproval() { return idApproval; }
    public void setIdApproval(Integer idApproval) { this.idApproval = idApproval; }

    public Date getDateApproval() { return dateApproval; }
    public void setDateApproval(Date dateApproval) { this.dateApproval = dateApproval; }

    public Date getDateBorrow() { return dateBorrow; }
    public void setDateBorrow(Date dateBorrow) { this.dateBorrow = dateBorrow; }

    public Date getDateScheduledReturn() { return dateScheduledReturn; }
    public void setDateScheduledReturn(Date dateScheduledReturn) { this.dateScheduledReturn = dateScheduledReturn; }

    public Date getDateReturn() { return dateReturn; }
    public void setDateReturn(Date dateReturn) { this.dateReturn = dateReturn; }

    public int getIdUpdate() { return idUpdate; }
    public void setIdUpdate(int idUpdate) { this.idUpdate = idUpdate; }

    public Timestamp getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Timestamp dateUpdate) { this.dateUpdate = dateUpdate; }

    // Convert from ResultSet
    public static BorrowBooksEntity convertFrom(ResultSet resultSet) throws SQLException {
        BorrowBooksEntity entity = new BorrowBooksEntity();
        entity.setIdRequest(resultSet.getInt("id_request"));
        entity.setIdApplicant(resultSet.getInt("id_applicant"));
        entity.setIdBook(resultSet.getInt("id_book"));
        entity.setDateRequest(resultSet.getDate("date_request"));
        entity.setStatus(resultSet.getString("status").charAt(0));
        entity.setIdApproval(resultSet.getObject("id_approval") != null ? resultSet.getInt("id_approval") : null);
        entity.setDateApproval(resultSet.getDate("date_approval"));
        entity.setDateBorrow(resultSet.getDate("date_borrow"));
        entity.setDateScheduledReturn(resultSet.getDate("date_scheduled_return"));
        entity.setDateReturn(resultSet.getDate("date_return"));
        entity.setIdUpdate(resultSet.getInt("id_update"));
        entity.setDateUpdate(resultSet.getTimestamp("date_update"));
        return entity;
    }

    // Convert from BorrowBooks model
    public static BorrowBooksEntity convertFrom(BorrowBooks model) {
        return new BorrowBooksEntity(
            model.getIdRequest(),
            model.getIdApplicant(),
            model.getIdBook(),
            model.getDateRequest(),
            model.getStatus(),
            model.getIdApproval(),
            model.getDateApproval(),
            model.getDateBorrow(),
            model.getDateScheduledReturn(),
            model.getDateReturn(),
            model.getIdUpdate(),
            model.getDateUpdate()
        );
    }

    // Constructor for BorrowBooksEntity
    public BorrowBooksEntity(int idRequest, int idApplicant, int idBook, Date dateRequest, char status, Integer idApproval, Date dateApproval, Date dateBorrow, Date dateScheduledReturn, Date dateReturn, int idUpdate, Timestamp dateUpdate) {
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
    }

    // Default constructor
    public BorrowBooksEntity() {}

    // Create BorrowBooks from BorrowBooksEntity
    public BorrowBooks toModel() {
        return new BorrowBooks(
            this.idRequest,
            this.idApplicant,
            this.idBook,
            this.dateRequest,
            this.status,
            this.idApproval,
            this.dateApproval,
            this.dateBorrow,
            this.dateScheduledReturn,
            this.dateReturn,
            this.idUpdate,
            this.dateUpdate
        );
    }
}
