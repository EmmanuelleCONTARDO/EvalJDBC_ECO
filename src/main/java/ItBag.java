
public class ItBag {

	private int it_bag_id;
	private String model;
	private String material;
	private String color;
	private double price;
	private double qty;
	private int id_favouritestore;

	public ItBag(int it_bag_id, String model, String material, String color, double price, double qty,
			int id_favouritestore) {
		this.it_bag_id = it_bag_id;
		this.model = model;
		this.material = material;
		this.color = color;
		this.qty = qty;
		this.id_favouritestore = id_favouritestore;

	}

	public int getIt_bag_id() {
		return it_bag_id;
	}

	public void setIt_bag_id(int it_bag_id) {
		this.it_bag_id = it_bag_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public int getId_favouritestore() {
		return id_favouritestore;
	}

	public void setId_favouritestore(int id_favouritestore) {
		this.id_favouritestore = id_favouritestore;
	}

}
