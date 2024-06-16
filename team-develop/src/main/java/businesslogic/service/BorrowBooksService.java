package businesslogic.service;

import businesslogic.model.BorrowBooks;
import dataaccess.dao.BorrowBooksDao;

public class BorrowBooksService {

    private BorrowBooksDao borrowBooksDao = new BorrowBooksDao();

    public void applyForBorrow(BorrowBooks borrowBooks) {
        borrowBooksDao.insert(borrowBooks);
    }
}
