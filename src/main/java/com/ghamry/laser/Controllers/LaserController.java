package com.ghamry.laser.Controllers;

import com.ghamry.laser.Entities.Laser;
import com.ghamry.laser.Services.LaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaserController {

    private LaserService laserService;

    @Autowired
    public LaserController(LaserService laserService) {
        this.laserService = laserService;
    }

    @RequestMapping("/lasers")
    public List<Laser> getAllLasers() {
        return laserService.getAllLasers();
    }

    @RequestMapping("/lasers/{id}")    // Only maps to GET request
    public Laser getFaultById(@PathVariable int id) {
        laserService.getFaultById(id);
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lasers")
    public void addLaser(@RequestBody Laser laser) {
        laserService.addLaser(laser);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/lasers/{id}")
    public void updateLaser(@RequestBody Laser laser) {
        laserService.updateLaser(laser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lasers/{id}")
    public void deleteLaser(@PathVariable int id) {
        laserService.deleteLaser(id);
    }
}
