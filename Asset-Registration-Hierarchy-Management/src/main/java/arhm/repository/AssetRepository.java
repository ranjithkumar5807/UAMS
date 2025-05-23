package arhm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arhm.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	List<Asset> findByLocation_Region(String region);
}
