package dataaccess.entity;

import businesslogic.model.BookCollectionBorrowBooksEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;

public class BookCollectionBorrowBooksEmployeeEntity {
    private int idRequest;
    private String nmEmployee;
    private String isbn;
    private String nmBook;
    private String publisher;
    private String note;
    private Date dateRequest;
    private Date dateBorrow;
    private Date dateScheduledReturn;
    private char status;
    private Integer idApproval;
    private Date dateApproval;
    private Date dateReturn;
    private int idUpdate;
    private Timestamp dateUpdate;

    // Getters and setters

    public static BookCollectionBorrowBooksEmployeeEntity convertFrom(ResultSet resultSet) throws SQLException {
        BookCollectionBorrowBooksEmployeeEntity entity = new BookCollectionBorrowBooksEmployeeEntity();
        entity.setIdRequest(resultSet.getInt("id_request"));
        entity.setNmEmployee(resultSet.getString("nm_employee"));
        entity.setIsbn(resultSet.getString("isbn"));
        entity.setNmBook(resultSet.getString("nm_book"));
        entity.setPublisher(resultSet.getString("publisher"));
        entity.setNote(resultSet.getString("note"));
        entity.setDateRequest(resultSet.getDate("date_request"));
        entity.setDateBorrow(resultSet.getDate("date_borrow"));
        entity.setDateScheduledReturn(resultSet.getDate("date_scheduled_return"));
        entity.setStatus(resultSet.getString("status").charAt(0));
        entity.setIdApproval((Integer) resultSet.getObject("id_approval"));
        entity.setDateApproval(resultSet.getDate("date_approval"));
        entity.setDateReturn(resultSet.getDate("date_return"));
        entity.setIdUpdate(resultSet.getInt("id_update"));
        entity.setDateUpdate(resultSet.getTimestamp("date_update"));
        return entity;
    }

    public BookCollectionBorrowBooksEmployee toModel() {
        return new BookCollectionBorrowBooksEmployee(
            this.idRequest,
            this.nmEmployee,
            this.isbn,
            this.nmBook,
            this.publisher,
            this.note,
            this.dateRequest,
            this.dateBorrow,
            this.dateScheduledReturn,
            this.status,
            this.idApproval,
            this.dateApproval,
            this.dateReturn,
            this.idUpdate,
            this.dateUpdate
        );
    }

    // Getters and setters...
	public int getIdRequest() { return idRequest; }
	public void setIdRequest(int idRequest) { this.idRequest = idRequest; }
	public String getNmEmployee() {	return nmEmployee; }
	public void setNmEmployee(String nmEmployee) { this.nmEmployee = nmEmployee; }
	public String getIsbn() { return isbn; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public String getNmBook() {	return nmBook; }
	public void setNmBook(String nmBook) { this.nmBook = nmBook; }
	public String getPublisher() { return publisher; }

	public void setPublisher(String publisher) { this.publisher = publisher; }
	public String getNote() { return note; }
	public void setNote(String note) { this.note = note; }
	public Date getDateRequest() {return dateRequest; }
	public void setDateRequest(Date dateRequest) {this.dateRequest = dateRequest; }
	public Date getDateBorrow() {return dateBorrow; }
	public void setDateBorrow(Date dateBorrow) { this.dateBorrow = dateBorrow; }
	public Date getDateScheduledReturn() { return dateScheduledReturn; }
	public void setDateScheduledReturn(Date dateScheduledReturn) { this.dateScheduledReturn = dateScheduledReturn;}
	public char getStatus() { return status; }
	public void setStatus(char status) { this.status = status; }
	public Integer getIdApproval() { return idApproval; }
	public void setIdApproval(Integer idApproval) {	this.idApproval = idApproval; }
	public Date getDateApproval() {	return dateApproval; }
	public void setDateApproval(Date dateApproval) { this.dateApproval = dateApproval; }

	public Date getDateReturn() { return dateReturn; }
	public void setDateReturn(Date dateReturn) { this.dateReturn = dateReturn; }
	public int getIdUpdate() { return idUpdate; }
	public void setIdUpdate(int idUpdate) {	this.idUpdate = idUpdate; }
	public Timestamp getDateUpdate() { return dateUpdate; }
	public void setDateUpdate(Timestamp dateUpdate) { this.dateUpdate = dateUpdate;	}
    
}
