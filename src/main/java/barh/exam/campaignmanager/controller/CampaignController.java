package barh.exam.campaignmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.model.NewCampaignModel;
import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.service.CampaignService;
import barh.exam.campaignmanager.service.ProductService;

@RestController
public class CampaignController {
	@Autowired
	private CampaignService campService;

	@Autowired
	private ProductService pService;
	
	/**
	 * 
	 * @param campaign(name , startDate, category, bid)
	 * @return campaing(same, includes list of products)
	 */
	// @ApiOperation(value = "Creates new campaign."
	@PostMapping(path = "/campaign", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> CreateCampaign(@RequestBody NewCampaignModel campaign) {
		return new ResponseEntity<>(campService.CreateCampaign(campaign), HttpStatus.OK);
	}

	@GetMapping(path = "/ad/{category}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ServeAd(@PathVariable String category) {
		return new ResponseEntity<>(pService.GetMainProductFromCampaign(category), HttpStatus.OK);
	}
}
