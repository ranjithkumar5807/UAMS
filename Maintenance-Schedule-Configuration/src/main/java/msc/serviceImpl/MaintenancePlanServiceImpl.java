package msc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msc.model.MaintenancePlan;
import msc.repository.MaintenancePlanRepository;
import msc.service.MaintenancePlanService;

import msc.exception.ResourceNotFoundException;

@Service
public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    @Autowired
    private MaintenancePlanRepository maintenancePlanRepository;

    @Override
    public MaintenancePlan createPlan(MaintenancePlan plan) {
        return maintenancePlanRepository.save(plan);
    }

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

