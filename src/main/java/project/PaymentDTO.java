package project;

public class PaymentDTO {

	private int payment_idx;
	private int member_idx;
	private String time_limit;
	private String pay_date;
	private String total_amount;
	private char agree1;
	private char agree2;
	private char agree3;
	private char status;
	private String type;
	private int playinfo_idx;
	
	public PaymentDTO(int payment_idx, int member_idx, String time_limit, char status, int playinfo_idx) {
		this.payment_idx = payment_idx;
		this.member_idx = member_idx;
		this.time_limit = time_limit;
		this.status = status;
		this.playinfo_idx = playinfo_idx;
	}

	public int getPayment_idx() {
		return payment_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public String getTime_limit() {
		return time_limit;
	}

	public String getPay_date() {
		return pay_date;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public char getAgree1() {
		return agree1;
	}

	public char getAgree2() {
		return agree2;
	}

	public char getAgree3() {
		return agree3;
	}

	public char getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public int getPlayinfo_idx() {
		return playinfo_idx;
	}

	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public void setTime_limit(String time_limit) {
		this.time_limit = time_limit;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public void setAgree1(char agree1) {
		this.agree1 = agree1;
	}

	public void setAgree2(char agree2) {
		this.agree2 = agree2;
	}

	public void setAgree3(char agree3) {
		this.agree3 = agree3;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPlayinfo_idx(int playinfo_idx) {
		this.playinfo_idx = playinfo_idx;
	}

	@Override
	public String toString() {
		return "PaymentDTO [payment_idx=" + payment_idx + ", member_idx=" + member_idx + ", time_limit=" + time_limit
				+ ", pay_date=" + pay_date + ", total_amount=" + total_amount + ", agree1=" + agree1 + ", agree2="
				+ agree2 + ", agree3=" + agree3 + ", status=" + status + ", type=" + type + ", playinfo_idx="
				+ playinfo_idx + "]";
	}
	
	
}

