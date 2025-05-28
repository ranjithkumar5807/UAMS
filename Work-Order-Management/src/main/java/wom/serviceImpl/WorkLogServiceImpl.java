package wom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wom.model.WorkLog;
import wom.repository.WorkLogRepository;
import wom.service.WorkLogService;

@Service
public class WorkLogServiceImpl implements WorkLogService {

	@Autowired
	WorkLogRepository repo;
	@Override
	public WorkLog createWorkLog(WorkLog workLog) {
		
		return repo.save(workLog);
	}

	@Override
	public List<WorkLog> getAllWorkLogs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}




}
