package com.ghamry.laser.Services;

import com.ghamry.laser.CRUD.LaserRepository;
import com.ghamry.laser.Entities.Laser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaserService {

    private LaserRepository laserRepository;

    @Autowired
    public LaserService(LaserRepository laserRepository) {
        this.laserRepository = laserRepository;
    }

    public List<Laser> getAllLasers() {
        return new ArrayList<>(laserRepository.findAll());
    }

    public void addLaser(Laser laser) {
        laserRepository.save(laser);
    }

    public Laser getLaserById(int id) {
        Optional<Laser> valueReturned = laserRepository.findById(id);
        return valueReturned.orElse(null);
    }

    public void updateLaser(Laser laser) {
        laserRepository.save(laser);
    }

    public void deleteLaser(int id) {
        Laser laser = getLaserById(id);
        laserRepository.delete(laser);
    }
}
