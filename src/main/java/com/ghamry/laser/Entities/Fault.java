package com.ghamry.laser.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FaultTbl", schema="Lasers")
public class Fault {

    private int faultId;
    private String faultName;
    private String faultSolution;
    private Date faultDate;
    private int laserId;

    public Fault() {}

    public Fault(String faultName, String faultSolution, Date faultDate, int laserId) {
        super();
        this.faultName = faultName;
        this.faultSolution = faultSolution;
        this.faultDate = faultDate;
        this.laserId = laserId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FaultId")
    public int getFaultId() {
        return faultId;
    }

    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    @Basic
    @Column(name = "FaultName")
    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    @Basic
    @Column(name = "FaultSolution")
    public String getFaultSolution() {
        return faultSolution;
    }

    public void setFaultSolution(String faultSolution) {
        this.faultSolution = faultSolution;
    }

    @Basic
    @Column(name = "FaultDate")
    public Date getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Date faultDate) {
        this.faultDate = faultDate;
    }

    @Basic
    @Column(name = "LaserId")
    public int getLaserId() {
        return laserId;
    }

    public void setLaserId(int laserId) {
        this.laserId = laserId;
    }
}
