package dto;

public class LikeCountDTO {
	private int like;

	public LikeCountDTO(int like) {
		this.like = like;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "좋아요 수 : " + like;
	}
	
	
}
