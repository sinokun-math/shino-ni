package businesslogic.service;

import businesslogic.model.BookCollectionBorrowBooksEmployee;
import dataaccess.dao.BookCollectionBorrowBooksEmployeeDao;
import dataaccess.dao.BorrowBooksDao;
import dataaccess.entity.BookCollectionBorrowBooksEmployeeEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationService {
	private BorrowBooksDao borrowBooksDao = new BorrowBooksDao();

    private BookCollectionBorrowBooksEmployeeDao dao = new BookCollectionBorrowBooksEmployeeDao();

    public List<BookCollectionBorrowBooksEmployee> getAllApplications() {
        return dao.findAll()
        		.stream()
        		.map(BookCollectionBorrowBooksEmployeeEntity::toModel)
        		.collect(Collectors.toList());
    }

    public BookCollectionBorrowBooksEmployee getApplicationById(int idRequest) {
        return dao.findById(idRequest).toModel();
    }
    
    public void approveApplication(int idRequest, int idEmployee, Timestamp dateUpdate) {
        borrowBooksDao.updateStatus(idRequest, '2', idEmployee, idEmployee, dateUpdate); // '2' means "貸出中"
    }
    
    public void rejectApplication(int idRequest, int idEmployee, Timestamp dateUpdate) {
        borrowBooksDao.updateStatus(idRequest, '9', null, idEmployee, dateUpdate); // '9' means "却下"
        borrowBooksDao.updateLendingFlag(idRequest, '0'); // '0' means "貸出可"
    }
}
