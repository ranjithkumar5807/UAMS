package wom.service;

import java.util.List;

import wom.model.WorkOrder;

public interface WorkOrderService {

	
	WorkOrder createWorkOrder(WorkOrder workOrder);
	List<WorkOrder> getWorkOrdersByStatus(String Status);
	WorkOrder updateStatus(long WorkOrderId, String Status) throws Exception;

}
