package io.javabrains.springbootstarter.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByParentId(Product id);
	Optional<Product> findById(Long Id);
	

//@Query("Select io.javabrains.springbootstarter.product.ProductDto(p.id) from Product p"
//		+ " inner join user u on p.fk= u.id"
//		)
//List<ProductDto> findAllProducts();

//	public void save(Long id, Branch branch);
	
	
	//getAllTopic()
	//getTopic(String id)
	//updateTopic(String id)
	//deleteTopic(String id)
	
	

}
