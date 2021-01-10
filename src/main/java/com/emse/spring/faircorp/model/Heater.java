package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
public class Heater {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "power")
    private Long defaultPowerInWatt;
    @ManyToOne
    private Room room;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus HeaterStatus;

    public Heater(Room room, String name, Long defaultPowerInWatt, com.emse.spring.faircorp.model.HeaterStatus heaterStatus) {
    }
    public Heater(){}
    public Heater(String name, HeaterStatus status) {
        this.HeaterStatus = status;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDefaultPowerInWatt() {
        return defaultPowerInWatt;
    }

    public void setDefaultPowerInWatt(Long defaultPowerInWatt) {
        this.defaultPowerInWatt = defaultPowerInWatt;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public com.emse.spring.faircorp.model.HeaterStatus getHeaterStatus() {
        return HeaterStatus;
    }

    public void setHeaterStatus(com.emse.spring.faircorp.model.HeaterStatus heaterStatus) {
        HeaterStatus = heaterStatus;
    }
}
