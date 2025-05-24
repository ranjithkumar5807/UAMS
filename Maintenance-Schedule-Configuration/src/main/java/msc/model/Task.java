package msc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long taskId;
	
	private String description;
    private int estimatedHours;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MaintenancePlan maintenancePlan;

    public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public MaintenancePlan getMaintenance() {
		return maintenancePlan;
	}
	public void setMaintenancePlan(MaintenancePlan maintenancePlan) {
		this.maintenancePlan = maintenancePlan;
	}
	

    
}
