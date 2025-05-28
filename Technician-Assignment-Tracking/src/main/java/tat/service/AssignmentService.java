package tat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tat.model.Assignment;
import tat.model.Technician;
import tat.repository.AssignmentRepository;
import tat.repository.TechnicianRepository;

@Service
public class AssignmentService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
/*	public Assignment assignTechnicianToWorkOrder(Long technicianId, Long workOrderId) {
	    Technician technician = technicianRepository.findById(technicianId)
	            .orElseThrow(() -> new RuntimeException("Technician not found with ID: " + technicianId));

	    Assignment assignment = new Assignment();
	    assignment.setTechnician(technician);
	    assignment.setWorkOrderId(workOrderId);

	    return assignmentRepository.save(assignment);
	}                                                                                       */

	
	public List<Assignment> getAssignmentsByTechnicianId(Long technicianId){
		Technician technician = technicianRepository.findById(technicianId).orElseThrow();
		return assignmentRepository.findByTechnician(technician);
	}


}
