package barh.exam.campaignmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepo;

	@PersistenceContext
	EntityManager entityManager;

	public Product CreateProduct(Product product) {

		return productRepo.save(product);
	}

	public Product GetMainProductFromCampaign(String category) {

		Product productToReturn = productRepo.findTopByCategoryOrderByPriceDesc(category);
		if (productToReturn == null)
			productToReturn = productRepo.FindTopActiveCampaignedOrderByPriceDesc();
		return productToReturn;
	}

}
