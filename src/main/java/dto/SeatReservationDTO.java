package dto;

public class SeatReservationDTO {
	private String playName;
	private String poster_url;
	private String rank;
	private String seat_chart;
	private String time_limit;
	
	public SeatReservationDTO(String playName, String poster_url, String rank, String seat_chart, String time_limit) {
		this.playName = playName;
		this.poster_url = poster_url;
		this.rank = rank;
		this.seat_chart = seat_chart;
		this.time_limit = time_limit;
	}

	public String getPlayName() {
		return playName;
	}

	public String getPoster_url() {
		return poster_url;
	}
	
	public String getRank() {
		return rank;
	}

	public String getSeat_chart() {
		return seat_chart;
	}

	public String getTime_limit() {
		return time_limit;
	}

	@Override
	public String toString() {
		return "SeatReservationDTO [playName=" + playName + ", poster_url=" + poster_url + ", rank=" + rank
				+ ", seat_chart=" + seat_chart + ", time_limit=" + time_limit + "]";
	}
	
	
	
}


