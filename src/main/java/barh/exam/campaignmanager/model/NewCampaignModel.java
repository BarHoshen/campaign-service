package barh.exam.campaignmanager.model;

import java.util.Calendar;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class NewCampaignModel {

	
	private String name;
	private Calendar startDate;
	private String categoryName;
	private double bid;
	public NewCampaignModel() {
		super();
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	
	
}
