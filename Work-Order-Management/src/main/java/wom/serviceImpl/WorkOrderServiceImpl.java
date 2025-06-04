package wom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import wom.clients.PlanClient;
import wom.dto.PlanDTO;
import wom.exception.PlanNotFoundException;
import wom.exception.WorkOrderNotFoundException;
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
	public WorkOrder createWorkOrder(WorkOrder workOrder, long planId){
		PlanDTO plan= planClient.getPlanById(planId);
		
		if(plan ==null){
			throw new PlanNotFoundException("Maintainance Plan not found with Id");
		
		}
		workOrder.setPlanId(planId);
		return repo.save(workOrder);
	}

	@Override
	public List<WorkOrder> getWorkOrdersByStatus(String status){
	    List<WorkOrder> workOrders = repo.findByStatus(status);
	    
	    if (workOrders.isEmpty()) {
	       throw new WorkOrderNotFoundException("No workOrders with status");
	    }
	    
	    return workOrders;
	}	
		//need to work on converting the optional type objects to list type
		//return repo.findById(status);

	@Override
	public WorkOrder updateStatus(long workOrderId, WorkOrder workOrder) {
		// TODO Auto-generated method stub
		WorkOrder existingWorkOrder= repo.findById(workOrderId).orElse(null);
		if (existingWorkOrder==null) {
			throw new WorkOrderNotFoundException("WorkOrder not found");
		}
		existingWorkOrder.setStatus(workOrder.getStatus());

		return repo.save(existingWorkOrder);	
	}
	
	@Override
	public List<WorkOrder> getAllWorkOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public WorkOrder getWorkOrderById(Long workOrderId) {
		// TODO Auto-generated method stub
		return repo.findById(workOrderId).orElse(null);
	}

	

	
	
}
