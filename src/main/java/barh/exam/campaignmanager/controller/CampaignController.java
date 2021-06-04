package barh.exam.campaignmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.service.CampaignService;
import barh.exam.campaignmanager.service.ProductService;
import javassist.NotFoundException;

@RestController
public class CampaignController {
	@Autowired
	private CampaignService campService;

	@Autowired
	private ProductService pService;
	
	@PostMapping(path = "/campaign", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> CreateCampaign(@RequestBody Campaign campaign) {
		try {
			return new ResponseEntity<>(campService.CreateCampaign(campaign), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/ad")
	public ResponseEntity<?> ServeAd(@RequestParam String category) {
		return new ResponseEntity<>(pService.GetMainProductFromCampaign(category), HttpStatus.OK);
	}
}
