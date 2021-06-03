package barh.exam.campaignmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import barh.exam.campaignmanager.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, String> {

	
}
