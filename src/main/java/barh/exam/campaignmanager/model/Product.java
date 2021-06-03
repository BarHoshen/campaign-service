package barh.exam.campaignmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	private String title;
	@ManyToOne
	@JoinColumn(name = "category_name")
	private Category category;
	private double price;
	@Id
	private String productGuid;

	public Product() {
		super();
	}

	public Product(String title, double price, String productGuid) {
		super();
		this.title = title;
		this.price = price;
		this.productGuid = java.util.UUID.randomUUID().toString();

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductGuid() {
		return productGuid;
	}

}
