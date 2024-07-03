package project;

public class SeatStatusDTO {
	private String rank;
	private int count;
	
	public SeatStatusDTO(String rank, int count) {
		this.rank = rank;
		this.count = count;
	}

	public String getRank() {
		return rank;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "SeatStatusDTO [rank=" + rank + ", count=" + count + "]";
	}
}
