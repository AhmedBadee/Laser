package com.ghamry.laser.Services;

import com.ghamry.laser.CRUD.FaultRepository;
import com.ghamry.laser.Entities.Fault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FaultService {

    private FaultRepository faultRepository;

    @Autowired
    public FaultService(FaultRepository faultRepository) {
        this.faultRepository = faultRepository;
    }

    public List<Fault> getAllFaults() {
        List<Fault> faults = new ArrayList<>();
        faultRepository.findAll().forEach(faults::add);
        return faults;
    }

    public List<Fault> getFaultsByLaserId(int laserId) {
        return new ArrayList<>(faultRepository.findByLaserId(laserId));
    }

    public void addFault(Fault fault) {
        faultRepository.save(fault);
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
