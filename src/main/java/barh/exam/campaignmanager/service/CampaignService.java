package barh.exam.campaignmanager.service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.model.Category;
import barh.exam.campaignmanager.model.NewCampaignModel;
import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.repository.ICampaignRepository;
import barh.exam.campaignmanager.repository.ICategoryRepository;

@Service
public class CampaignService {

	@Autowired
	private ICampaignRepository campaignRepo;
	@Autowired
	private ICategoryRepository categoryRepo;
	@PersistenceContext
	EntityManager entityManager;

	// TODO Check if return full category with list of products
	// TODO Test what happens if you give it a fake category
	public Campaign CreateCampaign(NewCampaignModel campaign) {
		Category campaignCategory = entityManager.getReference(Category.class, campaign.getCategoryName());
		return campaignRepo
				.save(new Campaign(campaign.getName(), campaign.getStartDate(), campaignCategory, campaign.getBid()));
		
	}

	

}
