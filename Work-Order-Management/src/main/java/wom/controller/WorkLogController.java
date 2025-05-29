package wom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wom.model.WorkLog;
import wom.serviceImpl.WorkLogServiceImpl;

@RestController
@RequestMapping("/api/work-orders")
public class WorkLogController {
	
	@Autowired
	WorkLogServiceImpl workLogService;
	
	@PostMapping("/worklogs")
	public WorkLog createWorkLog(@RequestBody WorkLog workLog) {
		return workLogService.createWorkLog(workLog);
	}
	
	@GetMapping("/worklogs")
	public List<WorkLog> getAllWorkLogs(){
		return workLogService.getAllWorkLogs();
	}

}
