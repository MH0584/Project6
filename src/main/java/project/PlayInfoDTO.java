package project;

public class PlayInfoDTO {
	
	private String playName;
	private String playhallName;
	private int playtime;
	private String start_date;
	private String end_date;
	private String poster_url;
	private String view_class;
	
	public PlayInfoDTO(String playName, String playhallName, int playtime, String start_date, String end_date,
			String poster_url, String view_class) {
		this.playName = playName;
		this.playhallName = playhallName;
		this.playtime = playtime;
		this.start_date = start_date;
		this.end_date = end_date;
		this.poster_url = poster_url;
		this.view_class = view_class;
	}

	public String getPlayName() {
		return playName;
	}

	public String getPlayhallName() {
		return playhallName;
	}

	public int getPlaytime() {
		return playtime;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getPoster_url() {
		return poster_url;
	}

	public String getView_class() {
		return view_class;
	}

	@Override
	public String toString() {
		return playName + "   " + playhallName + "   " + playtime + "   " + start_date + "   " + end_date + "   " + poster_url + "   " + view_class;
	}

	
}