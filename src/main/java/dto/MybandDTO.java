package dto;

public class MybandDTO {
	private String meet_name;
	private String url;
	private int meet_member_count;
	
	public MybandDTO(String meet_name, String url, int meet_member_count) {
		this.meet_name = meet_name;
		this.url = url;
		this.meet_member_count = meet_member_count;
	}
	
	public String getMeet_name() {
		return meet_name;
	}
	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getMeet_member_count() {
		return meet_member_count;
	}
	public void setMeet_member_count(int meet_member_count) {
		this.meet_member_count = meet_member_count;
	}
	
	@Override
	public String toString() {
		return meet_name + ", " + url + ", " + meet_member_count;
	}
	
}
