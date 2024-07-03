package dto;

public class SeatPriceDTO {
	private String rank;
	private int price;

	public SeatPriceDTO(String rank, int price) {
		this.rank = rank;
		this.price = price;
	}
	
	public String getRank() {
		return rank;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "SeatPriceDTO [rank=" + rank + ", price=" + price + "]";
	}
	
	
}
