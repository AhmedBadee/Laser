package com.ghamry.laser.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "laser_tbl", schema="Lasers")
public class Laser {

    private int laserId;
    private String laserName;
    private Set<Fault> faults;

    public Laser() { }

    public Laser(String laserName) {
        this.laserName = laserName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "laser_id")
    public int getLaserId() {
        return laserId;
    }

    public void setLaserId(int laserId) {
        this.laserId = laserId;
    }

    @Basic
    @Column(name = "laser_name", nullable = false)
    public String getLaserName() {
        return laserName;
    }

    public void setLaserName(String laserName) {
        this.laserName = laserName;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "laser", cascade = CascadeType.ALL)
    public Set<Fault> getFaults() {
        return faults;
    }

    public void setFaults(Set<Fault> faults) {
        this.faults = faults;
    }
}
