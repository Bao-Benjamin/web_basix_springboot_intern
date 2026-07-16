package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

public class CheckoutResponse {
	private long numberOfDay;
	private double baseFee;
	private double lateFee;
	private double totalFee;
	public CheckoutResponse() {
		super();
	}
	public CheckoutResponse(long numberOfDay, double baseFee, double lateFee, double totalFee) {
		super();
		this.numberOfDay = numberOfDay;
		this.baseFee = baseFee;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
	}
	public long getNumberOfDay() {
		return numberOfDay;
	}
	public void setNumberOfDay(long numberOfDay) {
		this.numberOfDay = numberOfDay;
	}
	public double getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(double baseFee) {
		this.baseFee = baseFee;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public double getLateFee() {
		return lateFee;
	}
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
	
	
}
