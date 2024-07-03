package project;

public class PlayScheduleDTO {

	private String play_date;
	private String start_time;
	private int play_order;

	public PlayScheduleDTO(String play_date, String start_time, int play_order) {
		this.play_date = play_date;
		this.start_time = start_time;
		this.play_order = play_order;
	}
	public String getPlay_date() {
		return play_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public int getPlay_order() {
		return play_order;
	}
	
	@Override
	public String toString() {
		return "PlayScheduleDTO [play_date=" + play_date + ", start_time=" + start_time + ", play_order=" + play_order
				+ "]";
	}
	
	
}
