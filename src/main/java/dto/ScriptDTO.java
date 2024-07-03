package dto;

//
//INSERT INTO script(script_idx, play_idx, member_idx, payment_idx, title, content, star_rating,reg_date) 
//VALUES (Seq_script.nextval, 1, 1, 1, '노래도 연기도 연출도 모두 최고!!!', '배우의 내면 연기로 

public class ScriptDTO {
	
	
	
	
	private int play_idx;
	private int member_idx;
	private int payment_idx;
	private String title;
	private String content;
	private double star_rating;
	
	public ScriptDTO(int play_idx, int member_idx, int payment_idx, String title, String content, double star_rating) {
		this.play_idx = play_idx;
		this.member_idx = member_idx;
		this.payment_idx = payment_idx;
		this.title = title;
		this.content = content;
		this.star_rating = star_rating;
	}

	public int getPlay_idx() {
		return play_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public int getPayment_idx() {
		return payment_idx;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public double getStar_rating() {
		return star_rating;
	}

	public void setPlay_idx(int play_idx) {
		this.play_idx = play_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setStar_rating(double star_rating) {
		this.star_rating = star_rating;
	}

	@Override
	public String toString() {
		return "ScriptDTO [play_idx=" + play_idx + ", member_idx=" + member_idx + ", payment_idx=" + payment_idx
				+ ", title=" + title + ", content=" + content + ", star_rating=" + star_rating + "]";
	}

}
	
	
   