package dataaccess.entity;

import businesslogic.model.BorrowBooks;
import businesslogic.model.status.BorrowBooksStatus;

public class BorrowBooksConverter {
	
	// Convert from model
    public static BorrowBooksEntity convertFrom(BorrowBooks model) {
        BorrowBooksEntity entity = new BorrowBooksEntity();
        
        entity.setIdRequest(model.getIdRequest());
        entity.setIdApplicant(model.getIdApplicant());
        entity.setIdBook(model.getIdBook());
        entity.setDateRequest(model.getDateRequest());
        entity.setStatus(BorrowBooksStatus.fromModelValue(model.getStatus()));
        entity.setIdApproval(model.getIdApproval());
        entity.setDateApproval(model.getDateApproval());
        entity.setDateBorrow(model.getDateBorrow());
        entity.setDateScheduledReturn(model.getDateScheduledReturn());
        entity.setDateReturn(model.getDateReturn());
        entity.setIdUpdate(model.getIdUpdate());
        entity.setDateUpdate(model.getDateUpdate());
        
        return entity;
    }
    
    public static BorrowBooks ConvertTomodel(BorrowBooksEntity entity) {
    	return new BorrowBooks.Builder(
                entity.getIdRequest(),
                entity.getIdApplicant(),
                entity.getIdBook(),
                entity.getDateRequest(),
                BorrowBooksStatus.fromDbValue(entity.getStatus()),
                entity.getDateBorrow(),
                entity.getDateScheduledReturn(),
                entity.getIdUpdate(),
                entity.getDateUpdate())
    			.idApproval(entity.getIdApproval())
    			.dateApproval(entity.getDateApproval())
    			.dateReturn(entity.getDateReturn())
    			.build();
    }
}