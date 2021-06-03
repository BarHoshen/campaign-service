package barh.exam.campaignmanager.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Campaign {

	@Id
	private String name;
	private Calendar startDate;
	@ManyToOne
	@JoinColumn(name = "category_name")
	private Category category;
	private double bid;
	
	public Campaign() {
		super();
	}

	public Campaign(String name, Calendar startDate, Category category, double bid) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.category = category;
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}
	

}