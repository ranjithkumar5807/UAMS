package wom.service;

import java.util.List;

import wom.model.WorkOrder;

public interface WorkOrderService {

	
	WorkOrder createWorkOrder(WorkOrder workOrder, long planId) throws Exception;
	List<WorkOrder> getWorkOrdersByStatus(String Status);
	WorkOrder updateStatus(long WorkOrderId, WorkOrder workOrder) throws Exception;
	List<WorkOrder> getAllWorkOrders();

}
