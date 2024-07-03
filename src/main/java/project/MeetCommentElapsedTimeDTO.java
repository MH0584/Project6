package project;

public class MeetCommentElapsedTimeDTO {
	private String day;
	private String time;
	private String minute;
	
	public MeetCommentElapsedTimeDTO(String day, String time, String minute) {
		super();
		this.day = day;
		this.time = time;
		this.minute = minute;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "경과일 : " + day + ", 경과시간 : " + time + ", 경과분 : " + minute;
	}

	
	
}
