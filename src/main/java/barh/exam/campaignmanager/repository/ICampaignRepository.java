package barh.exam.campaignmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import barh.exam.campaignmanager.model.Campaign;

public interface ICampaignRepository extends JpaRepository<Campaign, String> {

	
}
