package barh.exam.campaignmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import barh.exam.campaignmanager.model.Product;

public interface IProductRepository extends JpaRepository<Product, String> {

	Product findTopByCategoryOrderByPriceDesc(String category);

	@Query(value = 
			"SELECT *  FROM product prod where prod.price = (select MAX(prod.price) FROM product prod inner join campaign camp where prod.category = camp.category )",
			nativeQuery = true)
	Product FindTopCampaignedOrderByPriceDesc();

	boolean existsByCategory(String category);

}
