package businesslogic.model;

import java.sql.Timestamp;

public class Employee {
	private final int idEmployee;
	private final String nmEmployee;
	private final String knEmployee;
	private final String mailAddress;
	private final String password;
	private final boolean isAdmin;
	private final boolean isRetired;
	private final int idUpdate;
	private final Timestamp dateUpdate;
	
	public static class Builder {
		private int idEmployee;
		private String nmEmployee;
		private String knEmployee;
		private String mailAddress;
		private String password;
		private boolean isAdmin;
		private boolean isRetired;
		private int idUpdate;
		private Timestamp dateUpdate;
		
		public Builder(int idEmployee, String nmEmployee, String knEmployee, String mailAddress, String password,
				boolean isAdmin, boolean isRetired, int idUpdate, Timestamp dateUpdate) {
			super();
			this.idEmployee = idEmployee;
			this.nmEmployee = nmEmployee;
			this.knEmployee = knEmployee;
			this.mailAddress = mailAddress;
			this.password = password;
			this.isAdmin = isAdmin;
			this.isRetired = isRetired;
			this.idUpdate = idUpdate;
			this.dateUpdate = dateUpdate;
		}
		
		// a build method
        public Employee build() {
            return new Employee(this);
        }
	}

	public Employee(Builder builder) {
		this.idEmployee = builder.idEmployee;
		this.nmEmployee = builder.nmEmployee;
		this.knEmployee = builder.knEmployee;
		this.mailAddress = builder.mailAddress;
		this.password = builder.password;
		this.isAdmin = builder.isAdmin;
		this.isRetired = builder.isRetired;
		this.idUpdate = builder.idUpdate;
		this.dateUpdate = builder.dateUpdate;
	}

	// Getters
	public int getIdEmployee() {
		return idEmployee;
	}

	public String getNmEmployee() {
		return nmEmployee;
	}

	public String getKnEmployee() {
		return knEmployee;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public boolean getIsRetired() {
		return isRetired;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public Timestamp getDateUpdate() {
		return dateUpdate;
	}

}
