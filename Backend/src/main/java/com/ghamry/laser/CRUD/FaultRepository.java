package com.ghamry.laser.CRUD;

import com.ghamry.laser.Entities.Fault;
import com.ghamry.laser.Entities.Laser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultRepository extends JpaRepository<Fault, Integer> {
    List<Fault> findByLaser(Laser laser);
}
