package project.template.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import project.template.dto.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	/*a. We can start our query method names with find...By, read...By, query...By, count...By, and get...By. 
	 *	 Before By we can add expression such as Distinct . After By we need to add property names of our entity. 
	 *b. To get data on the basis of more than one property we can concatenate property names using And and Or while creating method names. 
	 *c. If we want to use completely custom name for our method, we can use @Query annotation to write query. 
	 */
	List<Item> findByName(String Name);
	
	@Query("SELECT i FROM Item i WHERE i.name LIKE %:partialname%")
	List<Item> findByPartialName(@Param("partialname") String partialName);
}
