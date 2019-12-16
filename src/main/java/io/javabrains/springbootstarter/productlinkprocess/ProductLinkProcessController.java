package io.javabrains.springbootstarter.productlinkprocess;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ProductLinkProcessController {
	
	@Autowired
	private ProductLinkProcessService productLinkProcessService;
	
	@RequestMapping("/users/products/processes/productlinkprocess")
	public List<ProductLinkProcess> getAllProductLinkProcesses() {
		return productLinkProcessService.getAllProductLinkProcesses();
	}
	
	@RequestMapping("/users/products/processes/productlinkprocess/{id}")
	public Optional<ProductLinkProcess> getProductLinkProcess(@PathVariable Long id) {
		return productLinkProcessService.getProductLinkProcess(id);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/users/products/processes/productlinkprocess")
//	public void addProductLinkProcess(@RequestBody ProductLinkProcess productLinkProcesses) {
//
//		productLinkProcessService.addProductLinkProcess(productLinkProcesses);
//	}
//	@PostMapping("/api/branchitem")
	@RequestMapping(method=RequestMethod.POST, value="/users/products/processes/productlinkprocess")
	public void addProductLinkProcess(@RequestBody List<ProductLinkProcess> productLinkProcess,HttpServletRequest objReq) {		

			productLinkProcessService.addProductLinkProcess(productLinkProcess);
		
//		productLinkProcessRepository.saveAll(productLinkProcess)		
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/users/products/processes/productlinkprocess/{id}")
	public void deleteProductLinkProcess(@PathVariable Long id) {
		productLinkProcessService.deleteProductLinkProcess(id);
	}	
}
