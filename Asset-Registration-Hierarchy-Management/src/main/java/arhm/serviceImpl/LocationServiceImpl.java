package arhm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arhm.model.Location;
import arhm.repository.LocationRepository;
import arhm.service.LocationService;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationByAssetId(Long assetId) {
        return locationRepository.findByAsset_AssetId(assetId);
                
    }

	
}
