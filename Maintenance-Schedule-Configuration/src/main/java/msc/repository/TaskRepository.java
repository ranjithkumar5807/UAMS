package msc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import msc.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
		
	List<Task> findByMaintenancePlan_PlanId(Long planId);
}
