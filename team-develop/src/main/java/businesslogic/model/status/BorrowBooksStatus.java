package businesslogic.model.status;

public enum BorrowBooksStatus {
	RETURNED('0', "RETURMED"),
	WAIT_APPROVAL('1', "WAIT_APPROVAL"),
	LENDING('2', "LENDING"),
	REGECTED('9', "REGECTED");
	
	private char dbValue;
	private String modelValue;
	
	BorrowBooksStatus(char dbValue, String modelValue) {
		this.dbValue = dbValue;
		this.modelValue = modelValue;
	}
	
	BorrowBooksStatus(String modelValue) {
		this.modelValue = modelValue;
	}
	
	public static String fromDbValue(char dbValue) {
		for (BorrowBooksStatus status : values()) {
			if (status.dbValue == dbValue) {
				return status.modelValue;
			}
		}
		throw new IllegalAccessError("Unknown database value.");
	}
	
	public static char fromModelValue(String modelValue) {
		for (BorrowBooksStatus status : values()) {
			if (modelValue.equals(status.modelValue)) {
				return status.dbValue;
			}
		}
		throw new IllegalAccessError("Unknown model value.");
	}
	
	
}