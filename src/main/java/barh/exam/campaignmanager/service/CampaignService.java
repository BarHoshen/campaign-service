package barh.exam.campaignmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.repository.ICampaignRepository;
import barh.exam.campaignmanager.repository.IProductRepository;
import javassist.NotFoundException;

@Service
public class CampaignService {

	@Autowired
	private ICampaignRepository campaignRepo;

	@Autowired
	private IProductRepository productRepo;

	public Campaign CreateCampaign(Campaign campaign) throws NotFoundException {
		if (productRepo.existsByCategory(campaign.getCategory())) {
			return campaignRepo.save(new Campaign(campaign.getName(), campaign.getStartDate(), campaign.getCategory(),
					campaign.getBid()));
		}
		throw new NotFoundException("Category " + campaign.getCategory() + " not found!");
	}

}
