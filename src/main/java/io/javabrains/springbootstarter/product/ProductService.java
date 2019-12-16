package io.javabrains.springbootstarter.product;

import java.util.Date;
//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = productRepository.findAll();	
		return products;
	}
	
	
//	public List<ProductDto> getAllProductsByDto(){
//		List<ProductDto> products = productRepository.findAllProducts();	
//		return products;
//	}
	
	public Optional<Product> getProduct(Long id) {
		Optional<Product> product=productRepository.findById(id);
		return product;			
	}

	public Product addProduct(Product product) {
		if(product.getId()==null) {
			product.setCreatedOn(new Date());
			if(product.getParentId() == null)
				product.setField(randomCode());	
	
			else
				product.setField(addRandomCode(product.getParentId()));	
			
				product.setParentId(product.getParentId());
			}
		else
		{
			Product updateProduct =productRepository.findById(product.getId()).orElse(null);
			product.setField(updateProduct.getField());
			product.setCreatedOn(updateProduct.getCreatedOn());
			product.setUpdatedOn(new Date());
			
		}
		return productRepository.save(product);
		
	}

//	public void updateProduct(Product product, Long id) {	
//		if(product.getId()== id) {
//			product.setCreatedOn(new Date());
//			product.setUpdatedOn(new Date());
//			product.setUpdatedOn(new Date());
//		}
//		else
//		{
//			Product updateProduct =productRepository.findById(product.getId()).orElse(null);
//			product.setCreatedOn(updateProduct.getCreatedOn());
//			product.setUpdatedOn(updateProduct.getUpdatedOn());
//			product.setUpdatedBy(updateProduct.getUpdatedBy());
//			product.setUpdatedOn(new Date());
//		}
//		productRepository.save(product);
//
//	}
	
//	public void updateProduct( Long id) {	
//		
//		
//		Product productObj = productRepository.findById(id);
//		if(productObj.getId()==id) {
//			productObj.setCreatedOn(new Date());
//			productOj.setUpdatedOn(new Date());
//			productOj.setUpdatedOn(new Date());
//		}
//		else
//		{
//			Product updateProduct =productRepository.findById(product.getId()).orElse(null);
//			product.setCreatedOn(updateProduct.getCreatedOn());
//			product.setUpdatedOn(updateProduct.getUpdatedOn());
//			product.setUpdatedBy(updateProduct.getUpdatedBy());
//			product.setUpdatedOn(new Date());
//		}
//		productRepository.save(product);
		
		

//	}
	public String randomCode() {
//		int count=0;
//		List<Product> productList= getProductByParentId(id);
//		if(productList!= null)
//		{count= productList.size();}
//		if(id==null) {
			int index = 0;
			char[] charSet = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
			StringBuffer sb = new StringBuffer();
	
			for (int i = 0; i <= 2; i++) {
			index = (int) (charSet.length * Math.random());
			sb.append(charSet[index]);
			} 
			
//				sb.append(".");
//				sb.append(count+1);
			
	//		sb.add(id.toString());	
			return sb.toString(); 
//			}
//		else {
//			int index = 0;
//			String[] charSet = { ".00", ".01", ".02", ".03"};
//
//			StringBuffer sb = new StringBuffer();
//
//			for (int i = 0; i <= 5; i++) {
//					index = (int) (charSet.length * Math.random());
//					sb.append(charSet[index]);
//			}
////			sb.add(id.toString());	
//			return sb.toString(); 
//			}
		}
		
	
	public String addRandomCode(Product parentId) {
		int count=0;
		List<Product> productList= productRepository.findByParentId(parentId);
		Optional<Product> product=productRepository.findById(parentId.getId());
		Product s= product.get();
		
		if(productList!= null)
		{count= productList.size();}
			StringBuffer sb = new StringBuffer();
	
			sb.append(s.getField());
				sb.append(".");
				sb.append(String.format("%03d", count+1));
//				sb.append(count+1);
			
	//		sb.add(id.toString());	
			return sb.toString(); 
//			}
//		else {
//			int index = 0;
//			String[] charSet = { ".00", ".01", ".02", ".03"};
//
//			StringBuffer sb = new StringBuffer();
//
//			for (int i = 0; i <= 5; i++) {
//					index = (int) (charSet.length * Math.random());
//					sb.append(charSet[index]);
//			}
////			sb.add(id.toString());	
//			return sb.toString(); 
//			}
		}
		
			
	
//		int number1 = (int)Math.floor( Math.random() * 10);
//		int number2 = (int)Math.floor( Math.random() * 10);
//		int number3 = (int)Math.floor( Math.random() * 10);
//		
//		String id1 = "" + number1 + "" + number2 + "" + number3;
//		
//		return id1;
//		int number =(int)Math.ceil(Math.random()*100);
//		return randomCode();
	
	

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public List<Product> getProductByParentId(Product parentId) {
	return productRepository.findByParentId(parentId);
		
	}

}
