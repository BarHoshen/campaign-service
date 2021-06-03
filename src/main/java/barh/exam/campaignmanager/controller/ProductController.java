package barh.exam.campaignmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import barh.exam.campaignmanager.model.Campaign;
import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@PostMapping(path = "/Product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> AddProduct(@RequestBody Product product) {
		return new ResponseEntity<>(pService.CreateProduct(product), HttpStatus.OK);
	}

}
