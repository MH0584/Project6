package dto;

public class MeetInfoWriteDTO {
	private String title;
	private String area;
	
	public MeetInfoWriteDTO(String title, String area) {
		this.title = title;
		this.area = area;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return  title + ", " + area;
	}
	
	
	
}
