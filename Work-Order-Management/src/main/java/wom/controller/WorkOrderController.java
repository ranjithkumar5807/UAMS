package wom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wom.model.WorkOrder;
import wom.serviceImpl.WorkOrderServiceImpl;

@RestController
@RequestMapping
public class WorkOrderController {
	
	@Autowired
	WorkOrderServiceImpl workOrderService;
	
	@PostMapping("/workorders")
	public WorkOrder createOrder(@RequestBody WorkOrder workOrder) {
		return workOrderService.createWorkOrder(workOrder);
	}
	

	@GetMapping("/workorders")
	public List<WorkOrder> getWorkOrdersByStatus(@RequestParam String status) {
		
		return workOrderService.getWorkOrdersByStatus(status);
	}
	
	@PatchMapping("/work-orders/{id}/{status}")
	public WorkOrder updateStatus(@PathVariable long id, @PathVariable String status) throws Exception {
		return workOrderService.updateStatus(id,status);
	}
}
