package com.emse.spring.faircorp.model;

import javax.persistence.*;

public class Light {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LightStatus lightStatus;
    @ManyToOne
    private Room room;

    public Light() {
    }

    public Light(String name, LightStatus status) {
        this.lightStatus = status;
        this.name = name;
    }

    public Light(Room room, String name, LightStatus lightStatus) {
        this.room = room;
        this.name = name;
        this.lightStatus = lightStatus;
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

    public LightStatus getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(LightStatus lightStatus) {
        this.lightStatus = lightStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
