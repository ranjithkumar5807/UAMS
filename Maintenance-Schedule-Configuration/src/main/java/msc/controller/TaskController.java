package msc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msc.model.MaintenancePlan;
import msc.model.Task;
import msc.serviceImpl.TaskServiceImpl;

@RestController
@RequestMapping("/api/maintenance-tasks")
public class TaskController {

	
	private TaskServiceImpl taskServiceImpl;
	
	@PostMapping
    public Task createPlan(@RequestBody Long planId, @RequestBody Task task) {
        return taskServiceImpl.addTaskToPlan(planId, task);
    }
	
	@GetMapping
	public List<Task> getTasksByPlanId(@RequestParam Long taskId) {
        return taskServiceImpl.getTasksByPlanId(taskId);
    }
	
	@PutMapping
	public Task updatePlan(@PathVariable Long taskId, @RequestBody Task task) {
        return taskServiceImpl.updateTask(taskId, task);
    } 
	
	@DeleteMapping("/delete")
    public void deleteMaintenancePlan(@RequestParam Long taskId) {
    	taskServiceImpl.deleteTask(taskId);
    }
}
