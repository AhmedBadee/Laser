package com.ghamry.laser.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fault_tbl", schema="Lasers")
public class Fault {

    private int faultId;
    private String faultName;
    private String faultSolution;
    private Date faultDate;
    private Laser laser;

    public Fault() {}

    public Fault(String faultName, String faultSolution, Date faultDate, Laser laser) {
        this.faultName = faultName;
        this.faultSolution = faultSolution;
        this.faultDate = faultDate;
        this.laser = laser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fault_id")
    public int getFaultId() {
        return faultId;
    }

    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    @Basic
    @Column(name = "fault_name", nullable = false)
    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    @Basic
    @Column(name = "fault_solution", nullable = false)
    public String getFaultSolution() {
        return faultSolution;
    }

    public void setFaultSolution(String faultSolution) {
        this.faultSolution = faultSolution;
    }

    @Basic
    @Column(name = "fault_date", nullable = false)
    public Date getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Date faultDate) {
        this.faultDate = faultDate;
    }

    @Basic
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "laser_id", nullable = false)
    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }
}
