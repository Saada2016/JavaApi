package io.javabrains.springbootstarter.process;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RestController
public class ProcessController {
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
//	private UserRepository usersRepository;
	
	@RequestMapping("/users/product/process")
	public List<Process> getAllProcesses() {
		return processService.getAllProcesses();
	}
	
	@RequestMapping("/users/product/process/{id}")
	public Optional<Process> getProcess(@PathVariable Long id) {
		return processService.getProcess(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/product/process")
	public Process addProcess(@RequestBody Process process) {


		return processService.addProcess(process);		
	}


//	@RequestMapping(method=RequestMethod.PUT, value="/users/product/process")
//	public void updateProcess(@RequestBody Process process,@PathVariable Long id) {
//	
//		processService.updateProcess(process,id);
//	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/product/process/{id}")
	public void deleteProcess(@PathVariable Long id) {
		processService.deleteProcess(id);
	}
	
}
