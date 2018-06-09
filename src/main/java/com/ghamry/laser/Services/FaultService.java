package com.ghamry.laser.Services;

import com.ghamry.laser.CRUD.FaultRepository;
import com.ghamry.laser.Entities.Fault;
import com.ghamry.laser.Entities.Laser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FaultService {

    private FaultRepository faultRepository;
    private LaserService laserService;

    @Autowired
    public FaultService(FaultRepository faultRepository, LaserService laserService) {
        this.faultRepository = faultRepository;
        this.laserService = laserService;
    }

    public List<Fault> getAllFaults() {
        return new ArrayList<>(faultRepository.findAll());
    }

    public List<Fault> getFaultsByLaserId(int laserId) {
        Laser laser = laserService.getLaserById(laserId);
        return new ArrayList<>(faultRepository.findByLaser(laser));
    }

    public String addFault(Fault fault) {
        Fault added = faultRepository.save(fault);

        if (added.getFaultId() != 0) {
            return "Added Successfully";
        }

        return "Failed";
    }

    public Fault getFaultById(int id) {
        Optional<Fault> valueReturned = faultRepository.findById(id);
        return valueReturned.orElse(null);
    }

    public void updateFault(Fault fault) {
        faultRepository.save(fault);
    }

    public void deleteFault(int id) {
        Fault fault = getFaultById(id);
        faultRepository.delete(fault);
    }
}
