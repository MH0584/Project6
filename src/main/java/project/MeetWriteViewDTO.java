package project;

public class MeetWriteViewDTO {
	private String nickname;
	private String profile;
	private int views;
	private String reg_date;
	private String content;
	private String file_url;
	
	public MeetWriteViewDTO(String nickname, String profile, int views, String reg_date, String content,
			String file_url) {
		this.nickname = nickname;
		this.profile = profile;
		this.views = views;
		this.reg_date = reg_date;
		this.content = content;
		this.file_url = file_url;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	@Override
	public String toString() {
		return "닉네임 : " + nickname + ", 프로필사진 : " + profile + ", 조회수 : " + views + ", 작성날짜 : "
				+ reg_date + ", 글 내용 : " + content + ", 첨부파일 : " + file_url;
	}
	
	
}
