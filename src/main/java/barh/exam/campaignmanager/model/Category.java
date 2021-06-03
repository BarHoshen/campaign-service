package barh.exam.campaignmanager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	private String name;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Product> categoryProducts;
	
	@OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
	private List<Campaign> categoryCampaigns;
	
	
	public Category() {
		super();
	}
	public Category(String name, List<Product> categoryProducts) {
		super();
		this.name = name;
		this.categoryProducts = categoryProducts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getCategoryProducts() {
		return categoryProducts;
	}
	public void setCategoryProducts(List<Product> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}
	
	
}
