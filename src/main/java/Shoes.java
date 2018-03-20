
public class Shoes {

	private long sh_id;
	private String model;
	private String material;
	private String color;
	private double price;
	private double shoe_size;
	//private int id_favouritestore;

	public Shoes(int sh_id, String model, String material, String color, double price, double shoe_size) {
		this.sh_id = sh_id;
		this.model = model;
		this.material = material;
		this.color = color;
		this.price = price;
		this.shoe_size = shoe_size;
		//this.id_favouritestore = id_favouritestore;

	}

	public Shoes() {
		
	}
	
	public long getSh_id() {
		return sh_id;
	}

	public void setSh_id(long sh_id) {
		this.sh_id = sh_id;
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

	public double getShoe_size() {
		return shoe_size;
	}

	public void setShoe_size(Double shoe_size) {
		this.shoe_size = shoe_size;
	}

//	public int getId_favouritestore() {
//		return id_favouritestore;
//	}
//
//	public void setId_favouritestore(int id_favouritestore) {
//		this.id_favouritestore = id_favouritestore;
//	}

}
