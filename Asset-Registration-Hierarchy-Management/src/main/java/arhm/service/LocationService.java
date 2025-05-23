package arhm.service;

import arhm.model.Location;

public interface LocationService {
	
	Location createLocation(Location location);

    Location getLocationByAssetId(Long assetId);

}

