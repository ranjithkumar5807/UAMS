package rcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rcl.service.ReportsService;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
	@Autowired
	private ReportsService reportsService;
	
	
	@GetMapping("/test")
	public String result() {
		return "I got it";
	}
	
	
	@GetMapping("/asset-history")
	public ResponseEntity<?>  getAssetHistory(@RequestParam Long assetId) {
		return ResponseEntity.ok(reportsService.getAssetMaintenanceHistory(assetId));
		
	}

	@GetMapping("/schedule-overview")
	public ResponseEntity<?> getScheduleOverView(@RequestParam String month) {
		return ResponseEntity.ok(reportsService.getUpcomingSchedule(month));
		
	}
	
	@GetMapping("/technician-summary")
	public ResponseEntity<?> getTechnicianSummary(@RequestParam Long technicianId) {
		return ResponseEntity.ok(reportsService.getTechnicianSummary(technicianId));
	}
}
