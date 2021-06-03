package barh.exam.campaignmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import barh.exam.campaignmanager.model.Product;

public interface IProductRepository extends JpaRepository<Product, String> {

	Product findTopByCategoryOrderByPriceDesc(String category);

	
}
