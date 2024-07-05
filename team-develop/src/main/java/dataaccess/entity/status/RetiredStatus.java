package dataaccess.entity.status;

public enum RetiredStatus {
	BELONG('0', false),
	RETIERED('1', true);
	
	private char dbValue;
	private boolean modelValue;
	
	private RetiredStatus(char dbValue, boolean modelValue) {
		this.dbValue = dbValue;
		this.modelValue = modelValue;
	}
	public char getDbValue() {
		return dbValue;
	}
	public void setDbValue(char dbValue) {
		this.dbValue = dbValue;
	}
	public boolean isModelValue() {
		return modelValue;
	}
	public void setModelValue(boolean modelValue) {
		this.modelValue = modelValue;
	}
	
	public static boolean fromDbValue(char dbValue) {
		for (RetiredStatus status : values()) {
			if (status.dbValue == dbValue)
				return status.modelValue;
		}
		throw new IllegalAccessError("Unknown value.");
	}
	
	public static char fromModelValue(boolean modelValue) {
		for (RetiredStatus status : values()) {
			if (status.modelValue == modelValue)
				return status.dbValue;
		}
		throw new IllegalAccessError("Unknown value.");
	}
}