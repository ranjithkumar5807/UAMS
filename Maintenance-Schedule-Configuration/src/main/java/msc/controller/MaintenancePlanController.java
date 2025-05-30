package msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import msc.model.MaintenancePlan;
import msc.service.MaintenancePlanService;
import msc.serviceImpl.MaintenancePlanServiceImpl;

@RestController
@RequestMapping("/api/maintenance-plans")
public class MaintenancePlanController {

    @Autowired
    private MaintenancePlanServiceImpl maintenancePlanServiceImpl;

    @PostMapping
    public MaintenancePlan createPlan(@RequestBody MaintenancePlan plan) {
        return maintenancePlanServiceImpl.createPlan(plan);
    }

    @GetMapping
    public List<MaintenancePlan> getPlans(@RequestParam Long assetId) {
        return maintenancePlanServiceImpl.getPlansByAssetId(assetId);
    }
    
    @GetMapping("/getAll")
    public List<MaintenancePlan> getAllMaintenancePlans() {
        return maintenancePlanServiceImpl.getAllPlans();
    }
    
//    @GetMapping("/get")
//    public String getPlans() {
//        return "Welcome";
//    }

    @PutMapping("/{id}")
    public  MaintenancePlan updatePlan(@PathVariable Long id, @RequestBody MaintenancePlan plan) {
        return maintenancePlanServiceImpl.updatePlan(id, plan);
    }
    
    @DeleteMapping("/delete")
    public void deleteMaintenancePlan(@RequestParam Long id) {
    	maintenancePlanServiceImpl.deletePlan(id);
    }
}

