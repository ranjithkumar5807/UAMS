package wom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wom.clients.PlanClient;
import wom.dto.PlanDTO;
import wom.model.WorkLog;
//import arhm.model.Asset;
import wom.model.WorkOrder;
import wom.repository.WorkOrderRepository;
import wom.service.WorkOrderService;

@Service
public class WorkOrderServiceImpl implements WorkOrderService{

	@Autowired
	private WorkOrderRepository repo;
	
	@Autowired
	private PlanClient planClient;


	@Override
	public WorkOrder createWorkOrder(WorkOrder workOrder, long planId) throws Exception {
		PlanDTO plan= planClient.getPlanById(planId);
		if(plan ==null){
			throw new Exception("Maintainance Plan not found");
		}
		workOrder.setPlanId(planId);
		return repo.save(workOrder);
	}

	@Override
	public List<WorkOrder> getWorkOrdersByStatus(String status) {
		return repo.findByStatus(status);
	
		//need to work on converting the optional type objects to list type
		//return repo.findById(status);
	}

	@Override
	public WorkOrder updateStatus(long workOrderId, WorkOrder workOrder) throws Exception {
		// TODO Auto-generated method stub
		WorkOrder existingWorkOrder= repo.findById(workOrderId).orElse(null);
		if (existingWorkOrder==null) {
			throw new Exception("WorkOrder not found");
		}
		existingWorkOrder.setStatus(workOrder.getStatus());

		return repo.save(existingWorkOrder);	
	}
	
	@Override
	public List<WorkOrder> getAllWorkOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	

	
	
}
