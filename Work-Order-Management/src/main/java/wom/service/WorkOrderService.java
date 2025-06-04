package wom.service;

import java.util.List;

import wom.exception.PlanNotFoundException;
import wom.exception.WorkOrderNotFoundException;
import wom.model.WorkOrder;

public interface WorkOrderService {

	
	WorkOrder createWorkOrder(WorkOrder workOrder, long planId);
    List<WorkOrder> getWorkOrdersByStatus(String Status);
	WorkOrder updateStatus(long WorkOrderId, WorkOrder workOrder);
	List<WorkOrder> getAllWorkOrders();

}
