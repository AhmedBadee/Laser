package com.ghamry.laser.Controllers;

import com.ghamry.laser.Entities.Fault;
import com.ghamry.laser.Services.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FaultController {

    private FaultService faultService;

    @Autowired
    public FaultController(FaultService faultService) {
        this.faultService = faultService;
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
        faultService.getFaultById(id);
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lasers/{laserId}/faults")
    public void addFault(@RequestBody Fault fault, @PathVariable byte laserId) {
        fault.setLaserId(laserId);
        faultService.addFault(fault);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/lasers/{laserId}/faults/{id}")
    public void updateFault(@RequestBody Fault fault, @PathVariable byte laserId) {
        fault.setLaserId(laserId);
        faultService.updateFault(fault);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lasers/{laserId}/faults/{id}")
    public void deleteFault(@PathVariable int id) {
        faultService.deleteFault(id);
    }
}
