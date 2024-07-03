package project;

public class MeetInfoWriteDTO {
	private String title;
	private String url;
	private String area;
	private String name;
	
	public MeetInfoWriteDTO(String title, String url, String area, String name) {
		this.title = title;
		this.url = url;
		this.area = area;
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  title + ", " + url + ", " + area + ", " + name;
	}
	
	
	
}
