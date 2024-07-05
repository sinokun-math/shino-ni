package dataaccess.entity.status;

public enum UserStatus {
	GENERAL_USER('0', true),
	ADMIN_USER('1', false);
	
	private final char dbValue;
	private final boolean modelValue;
	
	UserStatus(char dbValue, boolean modelValue) {
		this.dbValue = dbValue;
		this.modelValue = modelValue;
	}

	public char getDbValue() {
		return dbValue;
	}

	public boolean isModelValue() {
		return modelValue;
	}
	
	public static boolean fromDbValue(char dbValue) {
		for (UserStatus status : values()) {
			if (status.dbValue == dbValue) {
				return status.modelValue;
			}
		}
		throw new IllegalArgumentException("Unknown database value");
	}
	
	public static char fromModelValue(boolean modelValue) {
		for (UserStatus status : values()) {
			if (status.modelValue == modelValue) {
				return status.dbValue;
			}
		}
		throw new IllegalAccessError("Unknown model value");
	}
}