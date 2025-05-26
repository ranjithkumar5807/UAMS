package wom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wom.model.WorkLog;

public interface WorkLogRepository extends JpaRepository<WorkLog, String> {

}
