package app;

public class Fees {
	private int totalFees;
	private int feesPaid;
	private int feesPending;
	
	public Fees(SchoolDetails.SchoolName schoolName,int feesPaid) {
		this.totalFees = SchoolDetails.getSchoolFees(schoolName);
		this.feesPaid = feesPaid;
		this.feesPending = ((totalFees-feesPaid)>=0)? totalFees-feesPaid:0; 
	}
	
	public int getFeesPending() {
		return feesPending;
	}
	public int getFeesPaid() {
		return feesPaid;
	}
	public int getTotalFees() {
		return totalFees;
	}
}
