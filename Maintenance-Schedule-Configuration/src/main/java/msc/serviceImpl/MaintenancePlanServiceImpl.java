package msc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msc.model.MaintenancePlan;
import msc.model.Task;
import msc.repository.MaintenancePlanRepository;
import msc.service.MaintenancePlanService;
import msc.clients.AssetClient;
import msc.dto.AssetDTO;
import msc.exception.ResourceNotFoundException;

@Service
public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    @Autowired
    private MaintenancePlanRepository maintenancePlanRepository;

    @Override
    public MaintenancePlan createPlan(MaintenancePlan plan) {
        return maintenancePlanRepository.save(plan);
    }
    
//    @Autowired
//    private AssetClient assetClient;
//
//    @Override
//    public MaintenancePlan createPlan(MaintenancePlan plan) {
//        AssetDTO asset = assetClient.getAssetById(plan.getAssetId());
//        if (asset == null) {
//            throw new ResourceNotFoundException("Asset not found");
//        }
//        return maintenancePlanRepository.save(plan);
//    }
    
//    @Override
//    public MaintenancePlan createPlan(MaintenancePlan plan) {
//        AssetDTO asset = assetClient.getAssetById(plan.getAssetId());
//        if (asset == null) {
//            throw new ResourceNotFoundException("Asset not found");
//        }
//
//        // Link each task to the plan
//        if (plan.getTaskList() != null) {
//            for (Task task : plan.getTaskList()) {
//                task.setMaintenancePlan(plan);
//            }
//        }
//
//        return maintenancePlanRepository.save(plan);
//    }



    @Override
    public List<MaintenancePlan> getPlansByAssetId(Long assetId) {
        return maintenancePlanRepository.findByAssetId(assetId);
    }

    @Override
    public MaintenancePlan updatePlan(Long planId, MaintenancePlan updatedPlan) {
        MaintenancePlan existingPlan = maintenancePlanRepository.findById(planId)
            .orElseThrow(() -> new ResourceNotFoundException("Plan not found"));
        existingPlan.setFrequency(updatedPlan.getFrequency());
        existingPlan.setTaskList(updatedPlan.getTaskList());
        return maintenancePlanRepository.save(existingPlan);
    }

    @Override
    public void deletePlan(Long planId) {
        maintenancePlanRepository.deleteById(planId);
    }

    @Override
    public MaintenancePlan getPlanById(Long planId) {
        return maintenancePlanRepository.findById(planId)
            .orElseThrow(() -> new ResourceNotFoundException("Plan not found"));
    }

    @Override
    public List<MaintenancePlan> getAllPlans() {
        return maintenancePlanRepository.findAll();
    }
}

