package dataaccess.entity.status;

public enum LendingStatus {
	LENDABLE('0', false),
	NOT_LENDABLE('1', true);
	
	private final char dbValue;
	private final boolean modelValue;
	
	LendingStatus(char dbValue, boolean modelValue) {
		this.dbValue=dbValue;
		this.modelValue=modelValue;
	}
	
	public char getDbValue() {
		return this.dbValue;
	}
	
	public boolean getModelValue() {
		return this.modelValue;
	}
	
	public static LendingStatus fromDbValue(char dbValue) {
		for (LendingStatus status : values()) {
			if (status.dbValue == dbValue) {
				return status;
			}
		}
		throw new IllegalArgumentException("Unknown database value: " + dbValue);
	}
	
	public static LendingStatus fromModelValue(boolean modelValue) {
		for (LendingStatus status : values()) {
			if (status.modelValue == modelValue) {
				return status;
			}
		}
		throw new IllegalArgumentException("Unknown model value: " + modelValue);
	}
}


