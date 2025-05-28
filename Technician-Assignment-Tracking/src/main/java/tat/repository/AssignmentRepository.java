package tat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tat.model.Assignment;
import tat.model.Technician;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
	List<Assignment> findByTechnician(Technician technician);
   
}
