package msc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import msc.model.MaintenancePlan;

import java.util.List;


public interface MaintenancePlanRepository extends JpaRepository<MaintenancePlan, Long> {
		
	List<MaintenancePlan> findByAssetId(Long assetId);
}
