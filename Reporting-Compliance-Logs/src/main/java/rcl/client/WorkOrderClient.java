package rcl.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rcl.dto.WorkLogDTO;
import rcl.dto.WorkOrderDTO;

@FeignClient(name="Work-Order-Management")
public interface WorkOrderClient {
	

	@GetMapping("/api/work-orders/{id}")
	WorkOrderDTO getWorkOrderById(@PathVariable Long workOrderId);
	
	@GetMapping("/api/work-orders/assetId/{assetId}")
	List<WorkOrderDTO> getWorkOrdersByAssetId(@PathVariable Long assetId);
	
	@GetMapping("/api/work-orders/upcoming/month/{month}/year/{year}")
	List<WorkOrderDTO> getUpcomingWorkOrders(@PathVariable int month, @PathVariable int year);
	
	@GetMapping("/api/work-orders/work-logs/workOrderId/{workOrderId}")
	List<WorkLogDTO> getWorkLogsByWorkOrder(@PathVariable Long workOrderId);
			
	@GetMapping("/api/work-orders/work-logs/technicianId/{technicianId}")
	List<WorkLogDTO> getWorkLogsByTechnician(@PathVariable Long technicianId);
}
