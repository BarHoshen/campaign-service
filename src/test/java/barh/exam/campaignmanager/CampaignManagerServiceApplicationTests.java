package barh.exam.campaignmanager;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.service.CampaignService;
import barh.exam.campaignmanager.service.ProductService;
import javassist.NotFoundException;

@SpringBootTest

class CampaignManagerServiceApplicationTests {

	@Autowired
	private ProductService pService;

	@Autowired
	private CampaignService cService;

	@Test
	void contextLoads() {

		// Create new products
		pService.CreateProduct(new Product("Apple", 2.0, "food"));
		pService.CreateProduct(new Product("Carrot", 1.0, "food"));
		var expectedResultFruits = pService.CreateProduct(new Product("Melon", 2.5, "food"));
		pService.CreateProduct(new Product("Hammer", 4.0, "tools"));
		pService.CreateProduct(new Product("Nail", 1.0, "tools"));
		pService.CreateProduct(new Product("Pita", 0.5, "bread"));
		var expectedResultBread = pService.CreateProduct(new Product("Lachuch", 1.5, "bread"));

		Calendar today = Calendar.getInstance();

		Calendar elevenDaysAhead = Calendar.getInstance();
		elevenDaysAhead.add(Calendar.DAY_OF_YEAR, 11);

		try {
			// Starts in 11 days, so won't be served.
			cService.CreateCampaign(new Campaign("Cheap nails!", elevenDaysAhead, "tools", 0.5));

			// Starts Yesterday, so may be served
			cService.CreateCampaign(new Campaign("Fruits", today, "food", 0.5));

			// Starts Yesterday, so may be served, but lower than Fruits
			cService.CreateCampaign(new Campaign("Breads", today, "bread", 0.5));

		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Isn't active yet. Should return the generally that is active highest (food)
		var response1 = pService.GetMainProductFromCampaign("tools");
		// Doesn't exist. Should return the generally that is active highest (food)
		var response2 = pService.GetMainProductFromCampaign("Cheap nails!");
		// Exists, should return highest food.
		var response3 = pService.GetMainProductFromCampaign("food");
		// Exists, should return highest bread.
		var response4 = pService.GetMainProductFromCampaign("bread");

		Assertions.assertTrue(expectedResultFruits.getProductGuid().equals(response1.getProductGuid()));
		Assertions.assertTrue(expectedResultFruits.getProductGuid().equals(response2.getProductGuid()));
		Assertions.assertTrue(expectedResultFruits.getProductGuid().equals(response3.getProductGuid()));
		Assertions.assertTrue(expectedResultBread.getProductGuid().equals(response4.getProductGuid()));

	}

}
