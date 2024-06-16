package presentation.form;

import businesslogic.model.BookCollectionBorrowBooksEmployee;

public class ApplicationForm {
    private final int idRequest;
    private final String nmEmployee;
    private final String isbn;
    private final String nmBook;
    private final String publisher;
    private final String note;
    private final String dateBorrow;
    private final String dateScheduledReturn;

    public ApplicationForm(int idRequest, String nmEmployee, String isbn, String nmBook, String publisher, String note, String dateBorrow, String dateScheduledReturn) {
        this.idRequest = idRequest;
        this.nmEmployee = nmEmployee;
        this.isbn = isbn;
        this.nmBook = nmBook;
        this.publisher = publisher;
        this.note = note;
        this.dateBorrow = dateBorrow;
        this.dateScheduledReturn = dateScheduledReturn;
    }

    // Getters
    public int getIdRequest() { return idRequest; }
    public String getNmEmployee() { return nmEmployee; }
    public String getIsbn() { return isbn; }
    public String getNmBook() { return nmBook; }
    public String getPublisher() { return publisher; }
    public String getNote() { return note; }
    public String getDateBorrow() { return dateBorrow; }
    public String getDateScheduledReturn() { return dateScheduledReturn; }

    public static ApplicationForm fromModel(BookCollectionBorrowBooksEmployee model) {
        return new ApplicationForm(
            model.getIdRequest(),
            model.getNmEmployee(),
            model.getIsbn(),
            model.getNmBook(),
            model.getPublisher(),
            model.getNote(),
            model.getDateBorrow().toString(),
            model.getDateScheduledReturn().toString()
        );
    }
}
