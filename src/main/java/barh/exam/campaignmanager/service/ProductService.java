package barh.exam.campaignmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barh.exam.campaignmanager.model.Product;
import barh.exam.campaignmanager.repository.ICategoryRepository;
import barh.exam.campaignmanager.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepo;
	@Autowired
	private ICategoryRepository categoryRepo;

	@PersistenceContext
	EntityManager entityManager;
	
	public Product CreateProduct(Product product) {
		return productRepo.save(product);
	}

	public Product GetMainProductFromCampaign(String category) {

		Product productToReturn = null;

		// TODO try option B
		// Option A) check if category exists in any campain
		// Option B) add join to query
		if (categoryRepo.existsById(category))
			productToReturn = productRepo.findTopByCategoryOrderByPriceDesc(category);
		else
		{

		}
		return productToReturn;
	}

}
