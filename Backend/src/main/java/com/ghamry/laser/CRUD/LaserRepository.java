package com.ghamry.laser.CRUD;

import com.ghamry.laser.Entities.Laser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaserRepository extends JpaRepository<Laser, Integer> {

}
