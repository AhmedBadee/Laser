package com.ghamry.laser.Entities;

import javax.persistence.*;

@Entity
@Table(name = "LaserTbl", schema="Lasers")
public class Laser {

    private int laserId;
    private String laserName;

    public Laser() { }

    public Laser(String laserName) {
        this.laserName = laserName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LaserId")
    public int getLaserId() {
        return laserId;
    }

    public void setLaserId(int laserId) {
        this.laserId = laserId;
    }

    @Basic
    @Column(name = "LaserName")
    public String getLaserName() {
        return laserName;
    }

    public void setLaserName(String laserName) {
        this.laserName = laserName;
    }
}
