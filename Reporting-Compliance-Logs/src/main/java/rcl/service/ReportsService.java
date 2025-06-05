package rcl.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rcl.client.AssetClient;
import rcl.client.MaintenanceClient;
import rcl.client.TechnicianClient;
import rcl.client.WorkOrderClient;
import rcl.dto.AssetDTO;
import rcl.dto.MaintenancePlanDTO;
import rcl.dto.TechnicianDTO;
import rcl.dto.WorkLogDTO;
import rcl.dto.WorkOrderDTO;

@Service
public class ReportsService {
	@Autowired
	private TechnicianClient technicianClient;
	@Autowired
	private  WorkOrderClient  workOrderClient;
	@Autowired
	private AssetClient assetClient;
	@Autowired
	private MaintenanceClient maintenanceClient;
	
	public Map<String,Object> getTechnicianSummary(Long technicianId){
		TechnicianDTO tech=technicianClient.getTechnicianById(technicianId);
		List<WorkLogDTO> logs=workOrderClient.getWorkLogsByTechnician(technicianId);
		
		double avgHours=logs.stream()
				.mapToDouble(log-> Duration.between(log.startTime, log.endTime).toMinutes()/60.0)
				.average().orElse(0);
				
		Map<String,Object> report=new HashMap<>();
		report.put("technician",tech.name);
		report.put("skillSet",tech.skillSet);
		report.put("totalWorkLogs",logs.size());
		report.put("averageTimeSpentHours",avgHours);
		return report;
	
	}
	public Map<String,Object> getAssetMaintenanceHistory(Long assetId){
		List<WorkOrderDTO> workOrders=workOrderClient.getWorkOrdersByAssetId(assetId);
		List<Map<String,Object>> history=new ArrayList<>();
		
		for(WorkOrderDTO wo:workOrders) {
			List<WorkLogDTO> logs=workOrderClient.getWorkLogsByWorkOrder(wo.workOrderId);
			
			for(WorkLogDTO log:logs) {
				TechnicianDTO tech=technicianClient.getTechnicianById(log.technicianId);
				Map<String,Object> entry=new HashMap<>();
				entry.put("WorkOrderId",wo.workOrderId);
				entry.put("scheduledDate", wo.scheduledDate);
				entry.put("status", wo.status);
				entry.put("technician",tech.name);
				entry.put("timeSpentHours", Duration.between(log.startTime, log.endTime).toMinutes()/60.0);
				history.add(entry);
			}
			
		}
		Map<String,Object> report=new HashMap<>();
		report.put("assetId", assetId);
		report.put("maintenanceHistory", history);
		return report;
	}
	
	public Map<String,Object> getUpcomingSchedule(String month){
		List<WorkOrderDTO> workOrders=workOrderClient.getUpcomingWorkOrders(month);
		List<Map<String,Object>> result=new ArrayList<>();
		
		for(WorkOrderDTO wo: workOrders) {
			AssetDTO asset=assetClient.getAssetById(wo.assetId);
			MaintenancePlanDTO plan=maintenanceClient.getMaintenancePlan(wo.planId);
			
			Map<String,Object> entry=new HashMap<>();
			entry.put("workOrderId", wo.workOrderId);
			entry.put("scheduledDate",wo.scheduledDate);
			entry.put("status",wo.status);
			entry.put("assetName", asset.name);
			entry.put("location", asset.location);
			entry.put("planFrequency", plan.frequency);
			result.add(entry);
		}
		Map<String,Object> report=new HashMap<>();
		report.put(month, month);
		report.put("upcomingMaintenance", result);
		return report;
		
		
	}
	
	
	
	
	
}
