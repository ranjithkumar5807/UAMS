package tat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tat.service.TechnicianService;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {
	
	@Autowired
	private TechnicianService technicianService;
	
	

}
