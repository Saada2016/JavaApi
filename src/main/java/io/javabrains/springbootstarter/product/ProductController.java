package io.javabrains.springbootstarter.product;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.product.Product;

@Controller
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
//	private UserRepository usersRepository;
	
	@RequestMapping("/users/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/users/products/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/products")
	public Product addProduct(@RequestBody Product product) {


		return productService.addProduct(product);		
	}

//	@RequestMapping(method=RequestMethod.POST, value="/users/products/productId")
//	public List<Product> getCountParentId(@RequestBody Product product) {
//
//
//		return productService.getProductByParentId(product.getParentId());
//			
//	}


//	@RequestMapping(method=RequestMethod.PUT, value="/users/products")
//	public void updateProduct(@RequestBody Product product,@PathVariable Long id) {
//	
//		productService.updateProduct(product,id);
//	}
	
//	@RequestMapping(method=RequestMethod.PUT, value="/users/products")
//	public void updateProduct(@RequestBody Product product) {
//	
//		productService.updateProduct(product.getId());
//	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
}
