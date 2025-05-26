package wom.service;

import java.util.List;
import wom.model.WorkLog;;

public interface WorkLogService {
	
	 WorkLog createWorkLog(WorkLog workLog);
	 List<WorkLog> getAllWorkLogs();

  
}
