package wom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wom.model.WorkLog;
//import arhm.model.Asset;
import wom.model.WorkOrder;
import wom.repository.WorkOrderRepository;
import wom.service.WorkOrderService;

@Service
public class WorkOrderServiceImpl implements WorkOrderService{

	@Autowired
	private WorkOrderRepository repo;


	@Override
	public WorkOrder createWorkOrder(WorkOrder workOrder) {
		return repo.save(workOrder);
	}

	@Override
	public List<WorkOrder> getWorkOrdersByStatus(String status) {
		return repo.findByStatus(status);
	
		//need to work on converting the optional type objects to list type
		//return repo.findById(status);
	}

	@Override
	public WorkOrder updateStatus(long WorkOrderId, String status) throws Exception {
		// TODO Auto-generated method stub
		WorkOrder workOrder= repo.findById(WorkOrderId).orElse(null);
		if (workOrder==null) {
			throw new Exception("WorkOrder not found");
		}
		workOrder.setStatus(status);
		return repo.save(workOrder);	
	}
	
	@Override
	public List<WorkOrder> getAllWorkOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	

	
	
}
