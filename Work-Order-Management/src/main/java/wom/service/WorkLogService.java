package wom.service;

import java.util.List;
import wom.model.WorkLog;;

public interface WorkLogService {
	
	 WorkLog createWorkLog(WorkLog workLog, long technicianId, long workOrderId);
	 List<WorkLog> getAllWorkLogs();

  
}
