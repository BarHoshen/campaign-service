package barh.exam.campaignmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import barh.exam.campaignmanager.model.Product;

public interface IProductRepository extends JpaRepository<Product, String> {

	@Query(value = "SELECT *  FROM product prod where prod.category = :category and prod.price = (select MAX(prod.price) FROM product prod inner join campaign camp on prod.category = camp.category where camp.category = :category and  camp.start_date <= CURRENT_TIMESTAMP AND CURRENT_TIMESTAMP <= camp.start_date + interval 10 day)", nativeQuery = true)
	Product findTopByCategoryOrderByPriceDesc(@Param("category") String category);

	@Query(value = "SELECT *  FROM product prod where prod.price = (select MAX(prod.price) FROM product prod inner join campaign camp where prod.category = camp.category AND   camp.start_date <= CURRENT_TIMESTAMP AND CURRENT_TIMESTAMP <= camp.start_date + interval 10 day) ", nativeQuery = true)
	Product FindTopActiveCampaignedOrderByPriceDesc();

	boolean existsByCategory(String category);

}
