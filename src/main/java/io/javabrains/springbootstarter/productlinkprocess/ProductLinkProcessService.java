package io.javabrains.springbootstarter.productlinkprocess;

import java.util.Date;
//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.product.Product;

@Service
public class ProductLinkProcessService {
	
	@Autowired
	private ProductLinkProcessRepository productLinkProcessRepository;
	public List<ProductLinkProcess> getAllProductLinkProcesses(){
		List<ProductLinkProcess> productLinkProcess = productLinkProcessRepository.findAll();	
		return productLinkProcess;
	}
	
	public Optional<ProductLinkProcess> getProductLinkProcess(Long id) {
		Optional<ProductLinkProcess> productLinkProcess = productLinkProcessRepository.findById(id);
		return productLinkProcess;			
	}

	public void addProductLinkProcess(List<ProductLinkProcess> productLinkProcess) {
	
//		Product product =productLinkProcess.get(0).getProduct();
//		List<ProductLinkProcess> deleteobj= productLinkProcessRepository.findByProduct(product);
//		productLinkProcessRepository.deleteAll(deleteobj);
		for(ProductLinkProcess productLinkProcessbj: productLinkProcess)
		{
			if(productLinkProcessbj.getId()==null)
			{
			
				productLinkProcessbj.setCreatedOn(new Date());
				//productLinkProcessbj.setUpdatedOn(new Date());
			}
			else {
				ProductLinkProcess updateProductLinkProcess = productLinkProcessRepository.findById(((ProductLinkProcess) productLinkProcess).getId()).orElse(null);
				((ProductLinkProcess) productLinkProcess).setCreatedOn(updateProductLinkProcess.getCreatedOn());
				((ProductLinkProcess) productLinkProcess).setUpdatedOn(new Date());
			}	
		}	
		productLinkProcessRepository.saveAll(productLinkProcess);		
	}
	
	public void deleteProductLinkProcess(Long id) {
		productLinkProcessRepository.deleteById(id);
	}

}
