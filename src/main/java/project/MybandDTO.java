package project;

public class MybandDTO {
	private String meet_name;
	private String url;
	
	public MybandDTO(String meet_name, String url) {
		this.meet_name = meet_name;
		this.url = url;
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
	
	@Override
	public String toString() {
		return meet_name + ", " + url;
	}
	
}
