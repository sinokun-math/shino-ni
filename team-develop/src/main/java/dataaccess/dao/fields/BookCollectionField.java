package dataaccess.dao.fields;

public enum BookCollectionField {
	TABLE("book_collection"),
	
	BOOK_ID("id_book"),
	ISBN("isbn"),
	BOOK_NAME("nm_book"),
	BOOK_KANA("kn_book"),
	PUBLISHER("publisher"),
	NOTE("note"),
	LENDING_FLAG("flg_lending"),
	UPDATER_ID("id_update"),
	UPDATE_DATE("date_update");
	
	private String fieldName;

	private BookCollectionField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
