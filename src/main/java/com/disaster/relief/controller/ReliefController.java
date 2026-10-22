package com.disaster.relief.controller;

import com.disaster.relief.model.*;
import com.disaster.relief.service.ReliefService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disaster-relief")
@CrossOrigin(origins = "*")
public class ReliefController {

    private final ReliefService reliefService;

    public ReliefController(ReliefService reliefService) {
        this.reliefService = reliefService;
    }

    @GetMapping("/deploy")
    public List<String> deployWorkers() {
        return reliefService.deployAllWorkers();
    }

    @GetMapping("/supplies")
    public List<Supply> getAllSupplies() {
        return reliefService.getSupplies();
    }

    // --- Volunteer Registration Endpoints ---

    @PostMapping("/volunteers/medical")
    public String addMedicalVolunteer(@RequestParam String id, @RequestParam String name) {
        reliefService.addWorker(new MedicalVolunteer(id, name));
        return "Medical volunteer added successfully!";
    }

    @PostMapping("/volunteers/rescue")
    public String addRescueVolunteer(@RequestParam String id, @RequestParam String name) {
        reliefService.addWorker(new RescueVolunteer(id, name));
        return "Rescue volunteer added successfully!";
    }

    @PostMapping("/volunteers/food")
    public String addFoodVolunteer(@RequestParam String id, @RequestParam String name) {
        reliefService.addWorker(new FoodVolunteer(id, name));
        return "Food volunteer added successfully!";
    }

    // --- Supply Registration Endpoints ---

    @PostMapping("/supplies/food")
    public String addFoodSupply(@RequestParam String batchNumber, @RequestParam int quantity, @RequestParam String expiryDate) {
        reliefService.addSupply(new FoodSupply(batchNumber, quantity, expiryDate));
        return "Food supply added successfully!";
    }

    @PostMapping("/supplies/medical")
    public String addMedicalSupply(@RequestParam String batchNumber, @RequestParam int quantity, @RequestParam boolean requiresRefrigeration) {
        reliefService.addSupply(new MedicalSupply(batchNumber, quantity, requiresRefrigeration));
        return "Medical supply added successfully!";
    }
}