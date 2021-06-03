package barh.exam.campaignmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {

	private String title;
	private String category;
	private double price;
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
	private String productGuid;

	public Product() {
		super();
	}

	public Product(String title, double price, String category) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductGuid() {
		return productGuid;
	}

}
