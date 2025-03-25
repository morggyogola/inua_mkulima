package controller;

import entity.Farmer;
import models.FarmerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FarmerService;

@RestController
@RequestMapping("/api/v1/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Farmer> saveFarmer(@RequestBody FarmerDto farmerDto) {
        Farmer savedFarmer = farmerService.saveFarmer(farmerDto);
        return new ResponseEntity<>(savedFarmer, HttpStatus.CREATED);
    }
}