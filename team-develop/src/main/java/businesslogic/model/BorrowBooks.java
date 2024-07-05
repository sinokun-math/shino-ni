package businesslogic.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BorrowBooks {
    private final int idRequest;
    private final int idApplicant;
    private final int idBook;
    private final Date dateRequest;
    private final String status;
    private final Integer idApproval; // Allow null
    private final Date dateApproval; // Allow null
    private final Date dateBorrow;
    private final Date dateScheduledReturn;
    private final Date dateReturn; // Allow null
    private final int idUpdate;
    private final Timestamp dateUpdate;

    public static class Builder {
    	private  int idRequest;
        private  int idApplicant;
        private  int idBook;
        private  Date dateRequest;
        private  String status;
        private  Integer idApproval; // Allow null
        private  Date dateApproval; // Allow null
        private  Date dateBorrow;
        private  Date dateScheduledReturn;
        private  Date dateReturn; // Allow null
        private  int idUpdate;
        private  Timestamp dateUpdate;

        public Builder(int idRequest, int idApplicant, int idBook, Date dateRequest, String status, Date dateBorrow,
				Date dateScheduledReturn, int idUpdate, Timestamp dateUpdate) {
			this.idRequest = idRequest;
			this.idApplicant = idApplicant;
			this.idBook = idBook;
			this.dateRequest = dateRequest;
			this.status = status;
			this.dateBorrow = dateBorrow;
			this.dateScheduledReturn = dateScheduledReturn;
			this.idUpdate = idUpdate;
			this.dateUpdate = dateUpdate;
		}

		public Builder idApproval(Integer idApproval) {
			this.idApproval = idApproval;
			return this;
		}

		public Builder dateApproval(Date dateApproval) {
			this.dateApproval = dateApproval;
			return this;
		}

		public Builder dateReturn(Date dateReturn) {
			this.dateReturn = dateReturn;
			return this;
		}
        
        public BorrowBooks build() {
        	return new BorrowBooks(this);
        }
        
    }
    
    private BorrowBooks(Builder builder) {
    	
    	this.idRequest = builder.idRequest;
        this.idApplicant = builder.idApplicant;
        this.idBook = builder.idBook;
        this.dateRequest = builder.dateRequest;
        this.status = builder.status;
        this.dateBorrow = builder.dateBorrow;
        this.dateScheduledReturn = builder.dateScheduledReturn;
        this.idUpdate = builder.idUpdate;
        this.dateUpdate = builder.dateUpdate;

        this.idApproval = builder.idApproval;
        this.dateApproval = builder.dateApproval;
        this.dateReturn = builder.dateReturn;
    }

    // Getters
    public int getIdRequest() { return idRequest; }
    public int getIdApplicant() { return idApplicant; }
    public int getIdBook() { return idBook; }
    public Date getDateRequest() { return dateRequest; }
    public String getStatus() { return status; }
    public Integer getIdApproval() { return idApproval; }
    public Date getDateApproval() { return dateApproval; }
    public Date getDateBorrow() { return dateBorrow; }
    public Date getDateScheduledReturn() { return dateScheduledReturn; }
    public Date getDateReturn() { return dateReturn; }
    public int getIdUpdate() { return idUpdate; }
    public Timestamp getDateUpdate() { return dateUpdate; }
}
