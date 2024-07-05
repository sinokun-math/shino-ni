package dataaccess.entity;

import businesslogic.model.BookCollection;
import dataaccess.entity.status.LendingStatus;

public class BookCollectionConverter {

	public static BookCollectionEntity convertToEntity(BookCollection model) {
		BookCollectionEntity entity = new BookCollectionEntity();
		entity.setIdBook(model.getId());
		entity.setIsbn(model.getIsbn());
		entity.setNmBook(model.getName());
		entity.setKnBook(model.getKanaName());
		entity.setPublisher(model.getPublisher());
		entity.setNote(model.getNote());
		entity.setFlgLending(LendingStatus.fromModelValue(model.isLendable()).getDbValue()); // booleanからcharに変換
		entity.setIdUpdate(model.getUpdatedBy());
		entity.setDateUpdate(model.getUpdatedAt());
		return entity;
	}

	public static BookCollection convertToModel(BookCollectionEntity entity) {
		return new BookCollection.Builder(
				entity.getIdBook(), 
				entity.getIsbn(), 
				entity.getNmBook(),
				LendingStatus.fromDbValue(entity.getFlgLending()).getModelValue(), // charからbooleanに変換
				entity.getIdUpdate(), 
				entity.getDateUpdate())
				.knBook(entity.getKnBook())
				.publisher(entity.getPublisher())
				.note(entity.getNote())
				.build();
	}
}