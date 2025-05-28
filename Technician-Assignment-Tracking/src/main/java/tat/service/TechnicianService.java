package tat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tat.model.Technician;
import tat.repository.TechnicianRepository;

@Service
public class TechnicianService {
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	public List<Technician> getTechnicianByRegion(String region){
		return technicianRepository.findByRegion(region);
	}
	
	public Technician saveTechnician(Technician technician) {
		return technicianRepository.save(technician);
	}
	
	public Technician getTechnicianById(long id) {
		return technicianRepository.findById(id).orElse(null);
	}
    
}
