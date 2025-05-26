package wom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import arhm.model.Asset;
import wom.model.WorkOrder;
import wom.repository.WorkOrderRepository;
import wom.service.WorkOrderService;



public class WorkOrderServiceImpl implements WorkOrderService{

	@Autowired
	private WorkOrderRepository repo;


	@Override
	public WorkOrder createWorkOrder(WorkOrder workOrder) {
		return repo.save(workOrder);
	}

	@Override
	public List<WorkOrder> getWorkOrdersByStatus(String status) {
	
		//need to work on converting the optional type objects to list type
		return repo.findById(status);
	}

	@Override
	public WorkOrder updateWorkOrderStatus(String WorkOrderId, String status) throws Exception {
		// TODO Auto-generated method stub
		WorkOrder order1= repo.findById(WorkOrderId).orElse(null);
		if (order1!=null) {
			throw new Exception("WorkOrder not found");
		}
		order1.setStatus(status);
		return repo.save(order1);
		
	}


	

	
	
}
