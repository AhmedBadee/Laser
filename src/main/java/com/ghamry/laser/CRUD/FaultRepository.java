package com.ghamry.laser.CRUD;

import com.ghamry.laser.Entities.Fault;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaultRepository extends CrudRepository<Fault, Integer> {
    List<Fault> findByLaserId(int laserId);
}
