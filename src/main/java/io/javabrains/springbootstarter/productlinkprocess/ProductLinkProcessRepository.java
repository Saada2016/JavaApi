package io.javabrains.springbootstarter.productlinkprocess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.springbootstarter.product.Product;

public interface ProductLinkProcessRepository extends JpaRepository<ProductLinkProcess, Long> {

	List<ProductLinkProcess> findByProduct(Product product);
		

}
