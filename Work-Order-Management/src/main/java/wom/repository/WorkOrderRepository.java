package wom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wom.model.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, String > {

	 
}
