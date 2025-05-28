package arhm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arhm.model.Asset;
import arhm.repository.AssetRepository;
import arhm.service.AssetService;
@Service
public class AssetServiceImpl implements AssetService {
	
	@Autowired
	private AssetRepository repo;

	@Override
	public Asset createAsset(Asset asset) {
		
		return repo.save(asset);
	}

	@Override
	public Asset updateAsset(Long assetId, Asset asset) throws Exception {
		
		Asset asset1= repo.findById(assetId).orElse(null);
		if (asset1!=null) {
			throw new Exception("Asset not found");
		}
		return repo.save(asset);
	}

	@Override
	public List<Asset> getAllAssets() {
		
		return repo.findAll();
	}

	@Override
	public List<Asset> getAssetsByRegion(String region) {
		
		return repo.findByLocation_Region(region);
	}

	@Override
	public Asset getAssetById(Long assetId) {
		
		return repo.findById(assetId).orElse(null);
	}

}
