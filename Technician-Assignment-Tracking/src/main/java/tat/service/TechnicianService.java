package tat.service;
import java.util.List;

//import tat.model.Assignment;
import tat.model.Technician;

public interface TechnicianService {
    Technician saveTechnician(Technician technician);
//    Assignment assignTechnician(Long technicianId, Long workOrderId);
//    List<Assignment> getAssignmentsByTechnician(Long technicianId);
    List<Technician> getTechniciansByRegion(String region);
    Technician getTechnicianById(Long id);
    
}
