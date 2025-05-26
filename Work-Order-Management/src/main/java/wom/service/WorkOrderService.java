package wom.service;

import java.util.List;

import wom.model.WorkOrder;

public interface WorkOrderService {

	
	WorkOrder createWorkOrder(WorkOrder workOrder);
	List<WorkOrder> getWorkOrdersByStatus(String Status);
	WorkOrder updateWorkOrderStatus(String WorkOrderId, String Status) throws Exception;
	WorkOrder updateWorkOrder(String workOrderId, WorkOrder workOrder) throws Exception;
	List<WorkOrder> getAllWorkOrders();
	WorkOrder getWorkOrdersByWorkOrderId(String WorkOrderId);
	//WorkOrder getWorkOrdersByPlanID(String PlanId);
   
}
