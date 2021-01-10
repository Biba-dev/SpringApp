package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;
import java.util.Set;


public class RoomDto {
    private Long id;
    private String name;
    private Double currenttmp;
    private Integer floor;
    private Double tmp;
    private List<Heater> heaters;
    private Set<Window> window;
    private Building building;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.currenttmp = room.getCurrenttmp();
        this.floor = room.getFloor();
        this.tmp = room.getTmp();
        this.heaters = room.getHeaters();
        this.window = room.getWindow();
        this.building = room.getBuilding();
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

    public Double getCurrenttmp() {
        return currenttmp;
    }

    public void setCurrenttmp(Double currenttmp) {
        this.currenttmp = currenttmp;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getTmp() {
        return tmp;
    }

    public void setTmp(Double tmp) {
        this.tmp = tmp;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
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
