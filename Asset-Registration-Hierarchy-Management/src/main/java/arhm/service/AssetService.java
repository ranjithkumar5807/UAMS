package arhm.service;

import java.util.List;

import arhm.model.Asset;

public interface AssetService {
	
	 	Asset createAsset(Asset asset);

	    Asset updateAsset(Long assetId, Asset asset) throws Exception;

	    List<Asset> getAllAssets();

	    List<Asset> getAssetsByRegion(String region);

	    Asset getAssetById(Long assetId);

}
