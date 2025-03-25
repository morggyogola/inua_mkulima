package service;

import ch.qos.logback.core.testUtil.RandomUtil;
import entity.Farmer;
import models.FarmerDto;
import org.springframework.stereotype.Service;
import repository.FarmerRepository;

import java.util.Random;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer saveFarmer(FarmerDto farmerDto) {
        Random random = new Random();
        int accountNumber = 100000 + random.nextInt(100000); // Generates a 6-digit random number

        Farmer farmer = new Farmer();
        farmer.setFarmerName(farmerDto.farmerName());
        farmer.setIdNumber(farmerDto.idNumber());
        farmer.setAccountNumber(String.valueOf(accountNumber));
        return farmerRepository.save(farmer);
    }

}