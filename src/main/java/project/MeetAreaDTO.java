package project;

public class MeetAreaDTO {
	private String area;

	public MeetAreaDTO(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return area;
	}
	
}
