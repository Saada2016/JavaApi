package io.javabrains.springbootstarter.process;


import java.util.Date;
//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
	
	@Autowired
	private ProcessRepository processRepository;
	
	public List<Process> getAllProcesses(){
		List<Process> process = processRepository.findAll();	
		return process;
	}
	
	public Optional<Process> getProcess(Long id) {
		Optional<Process> process=processRepository.findById(id);
		return process;
				
	}

	public Process addProcess(Process process) {
		if(process.getId()==null) {
			process.setCreatedOn(new Date());
			process.setUpdatedOn(new Date());		
		}
		else
		{
			Process updateProcess =processRepository.findById(process.getId()).orElse(null);
			process.setCreatedOn(updateProcess.getCreatedOn());
			process.setUpdatedOn(new Date());
		}
		return processRepository.save(process);
		
	}

//	public void updateProcess(Process process, Long id) {	
//		if(process.getId()== id) {
//			process.setCreatedOn(new Date());
//			process.setUpdatedOn(new Date());
//			process.setUpdatedOn(new Date());
//		}
//		else
//		{
//			Process updateProcess =processRepository.findById(process.getId()).orElse(null);
//			process.setCreatedOn(updateProcess.getCreatedOn());
//			process.setUpdatedOn(updateProcess.getUpdatedOn());
//			process.setUpdatedBy(updateProcess.getUpdatedBy());
//			process.setUpdatedOn(new Date());
//		}
//		processRepository.save(process);
//
//	}

	public void deleteProcess(Long id) {
		processRepository.deleteById(id);
	}

}
