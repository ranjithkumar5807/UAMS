package wom.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import wom.model.WorkLog;;

public interface WorkLogService {
	
	 WorkLog createWorkLog(WorkLog workLog, long technicianId, long workOrderId);
	 List<WorkLog> getAllWorkLogs();
	 List<WorkLog> getWorkLogsByTechnician(Long technicianId);
	 List<WorkLog> getWorkLogsByWorkOrder(Long workOrderId);

  
}
