
public class FavouriteStore {

	private int fs_id;
	private String name;
	private String adress;
	private String favourite_item;
	private double price;

	public FavouriteStore(int fs_id, String name, String adress, String favourite_item, double price) {
		this.fs_id = fs_id;
		this.name = name;
		this.adress = adress;
		this.favourite_item = favourite_item;
		this.price = price;

	}

	public int getFs_id() {
		return fs_id;
	}

	public void setFs_id(int fs_id) {
		this.fs_id = fs_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getFavourite_item() {
		return favourite_item;
	}

	public void setFavourite_item(String favourite_item) {
		this.favourite_item = favourite_item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
