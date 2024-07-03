package dto;

public class CommentListViewDTO {
	String nickname;
	String profile;
	String content;
	
	public CommentListViewDTO(String nickname, String profile, String content) {
		this.nickname = nickname;
		this.profile = profile;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentListViewDTO [nickname=" + nickname + ", profile=" + profile + ", content=" + content + "]";
	}
	
	
}
