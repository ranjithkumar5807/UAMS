package msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import msc.model.MaintenancePlan;
import msc.service.MaintenancePlanService;

@RestController
@RequestMapping("/api/maintenance-plans")
public class MaintenancePlanController {

    @Autowired
    private MaintenancePlanService maintenancePlanService;

    @PostMapping
    public ResponseEntity<MaintenancePlan> createPlan(@RequestBody MaintenancePlan plan) {
        return new ResponseEntity<>(maintenancePlanService.createPlan(plan), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaintenancePlan>> getPlans(@RequestParam Long assetId) {
        return ResponseEntity.ok(maintenancePlanService.getPlansByAssetId(assetId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenancePlan> updatePlan(@PathVariable Long id, @RequestBody MaintenancePlan plan) {
        return ResponseEntity.ok(maintenancePlanService.updatePlan(id, plan));
    }
}

