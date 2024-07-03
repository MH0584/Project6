package dto;

public class TotalPriceDTO {
	private int price;

	public TotalPriceDTO(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "TotalPriceDTO [price=" + price + "]";
	}
	
	
}
