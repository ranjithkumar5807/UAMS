package wom.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import wom.dto.PlanDTO;

@FeignClient(name="Maintenance-Schedule-Configuration")
public interface PlanClient {

	@GetMapping("/api/maintenance-plans/{id}")
    PlanDTO getPlanById(@PathVariable long id );
       
}
