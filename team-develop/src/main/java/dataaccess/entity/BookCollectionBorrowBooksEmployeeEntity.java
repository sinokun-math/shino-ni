package dataaccess.entity;

import businesslogic.model.BookCollectionBorrowBooksEmployee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollectionBorrowBooksEmployeeEntity {
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
    private String nmEmployee;
    private String nmBook;

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

    public String getNmEmployee() { return nmEmployee; }
    public void setNmEmployee(String nmEmployee) { this.nmEmployee = nmEmployee; }

    public String getNmBook() { return nmBook; }
    public void setNmBook(String nmBook) { this.nmBook = nmBook; }

    // Convert from ResultSet
    public static BookCollectionBorrowBooksEmployeeEntity convertFrom(ResultSet resultSet) throws SQLException {
        BookCollectionBorrowBooksEmployeeEntity entity = new BookCollectionBorrowBooksEmployeeEntity();
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
        entity.setNmEmployee(resultSet.getString("nm_employee"));
        entity.setNmBook(resultSet.getString("nm_book"));
        return entity;
    }

    // Convert from BookCollectionBorrowBooksEmployee model
    public static BookCollectionBorrowBooksEmployeeEntity convertFrom(BookCollectionBorrowBooksEmployee model) {
        return new BookCollectionBorrowBooksEmployeeEntity(
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
            model.getDateUpdate(),
            model.getNmEmployee(),
            model.getNmBook()
        );
    }

    // Constructor for BookCollectionBorrowBooksEmployeeEntity
    public BookCollectionBorrowBooksEmployeeEntity(int idRequest, int idApplicant, int idBook, Date dateRequest, char status, Integer idApproval, Date dateApproval, Date dateBorrow, Date dateScheduledReturn, Date dateReturn, int idUpdate, Timestamp dateUpdate, String nmEmployee, String nmBook) {
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

    // Default constructor
    public BookCollectionBorrowBooksEmployeeEntity() {}

    // Create BookCollectionBorrowBooksEmployee from BookCollectionBorrowBooksEmployeeEntity
    public static BookCollectionBorrowBooksEmployee createBookCollectionBorrowBooksEmployee(BookCollectionBorrowBooksEmployeeEntity entity) {
        return new BookCollectionBorrowBooksEmployee(
            entity.getIdRequest(),
            entity.getIdApplicant(),
            entity.getIdBook(),
            entity.getDateRequest(),
            entity.getStatus(),
            entity.getIdApproval(),
            entity.getDateApproval(),
            entity.getDateBorrow(),
            entity.getDateScheduledReturn(),
            entity.getDateReturn(),
            entity.getIdUpdate(),
            entity.getDateUpdate(),
            entity.getNmEmployee(),
            entity.getNmBook()
        );
    }

    // Create List<BookCollectionBorrowBooksEmployee> from List<BookCollectionBorrowBooksEmployeeEntity>
    public static List<BookCollectionBorrowBooksEmployee> createBookCollectionBorrowBooksEmployeeList(List<BookCollectionBorrowBooksEmployeeEntity> entities) {
        return entities.stream()
                .map(BookCollectionBorrowBooksEmployeeEntity::createBookCollectionBorrowBooksEmployee)
                .collect(Collectors.toList());
    }
}
