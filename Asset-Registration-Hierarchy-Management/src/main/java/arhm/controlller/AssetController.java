package arhm.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import arhm.model.Asset;
import arhm.service.AssetService;


@Controller
@RequestMapping("/api/assets")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@PostMapping
	public Asset createAsset(@RequestBody Asset asset) {
		return assetService.createAsset(asset);
	}
	
	@GetMapping
	public List<Asset> getAllAssets(){
		return assetService.getAllAssets();
	}
	
	@PutMapping("/{id}")
	public Asset updateAsset(@PathVariable Long id,@RequestBody Asset asset) {
		try {
			return assetService.updateAsset(id, asset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	

}
