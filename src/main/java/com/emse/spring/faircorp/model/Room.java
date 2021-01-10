package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "floor", nullable = false)
    private Integer floor;
    @Column(nullable = false)
    private String name;
    @Column(name = "current_temperature")
    private Double currenttmp;

    @Column(name = "Target_temperature")
    private Double tmp;
    @OneToMany(mappedBy = "room")
    private List<Heater> heaters;
    @OneToMany(mappedBy = "room")
    private Set<Window> window;
    @ManyToOne
    private Building building;


    public Room(Integer floor, String name, Set<Window> window, List<Heater> heaters, Building building, Double currenttmp, Double tmp) {
    }

    public Room(Integer floor, String name, Double currenttmp, Double tmp, List<Heater> heaters, Set<Window> window, Building building) {
        this.floor = floor;
        this.name = name;
        this.currenttmp = currenttmp;
        this.tmp = tmp;
        this.heaters = heaters;
        this.window = window;
        this.building = building;
    }

    public Room() {
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public Room(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrenttmp() {
        return currenttmp;
    }

    public void setCurrenttmp(Double currenttmp) {
        this.currenttmp = currenttmp;
    }

    public Double getTmp() {
        return tmp;
    }

    public void setTmp(Double tmp) {
        this.tmp = tmp;
    }

    public Set<Window> getWindow() {
        return window;
    }

    public void setWindow(Set<Window> window) {
        this.window = window;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
