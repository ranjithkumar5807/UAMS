package tat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tat.model.Technician;
import tat.service.TechnicianService;

import java.util.List;

<<<<<<< HEAD
@CrossOrigin(origins ="http://localhost:3000")
=======

>>>>>>> c95938afd6a2253a4077053b13af63e672d9808e
@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping
    public Technician addTechnician(@RequestBody Technician technician) {
        return technicianService.saveTechnician(technician);
    }
    
    @GetMapping
    public List<Technician> getAllTechnicians() {
    	return technicianService.getAllTechnicians();
    }
    
    @GetMapping("/region/{region}")
    public List<Technician> getTechniciansByRegion(@PathVariable String region) {
        return technicianService.getTechniciansByRegion(region);
    }

    @GetMapping("/{id}")
    public Technician getTechnicianById(@PathVariable Long id) {
        return technicianService.getTechnicianById(id);
    }
    
}

