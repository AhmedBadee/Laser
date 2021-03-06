package com.ghamry.laser.Controllers;

import com.ghamry.laser.Entities.Fault;
import com.ghamry.laser.Entities.Laser;
import com.ghamry.laser.Services.FaultService;
import com.ghamry.laser.Services.LaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FaultController {

    private FaultService faultService;
    private LaserService laserService;

    @Autowired
    public FaultController(FaultService faultService, LaserService laserService) {
        this.faultService = faultService;
        this.laserService = laserService;
    }

    @RequestMapping("/lasers/faults")
    public List<Fault> getAllFaults() {
        return faultService.getAllFaults();
    }

    @RequestMapping("/lasers/{laserId}/faults")
    public List<Fault> getFaultsByLaserId(@PathVariable int laserId) {
        return faultService.getFaultsByLaserId(laserId);
    }

    @RequestMapping("/lasers/{laserId}/faults/{id}")    // Only maps to GET request
    public Fault getFaultById(@PathVariable int id) {
        return faultService.getFaultById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lasers/{laserId}/faults")
    public String addFault(@RequestBody Fault fault, @PathVariable int laserId) {
        Laser laser = laserService.getLaserById(laserId);
        fault.setLaser(laser);
        return faultService.addFault(fault);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/lasers/{laserId}/faults/{id}")
    public void updateFault(@RequestBody Fault fault, @PathVariable int laserId) {
        Laser laser = laserService.getLaserById(laserId);
        fault.setLaser(laser);
        faultService.updateFault(fault);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lasers/{laserId}/faults/{id}")
    public void deleteFault(@PathVariable int id) {
        faultService.deleteFault(id);
    }
}
