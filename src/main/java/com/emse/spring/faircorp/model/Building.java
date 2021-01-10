package com.emse.spring.faircorp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity()
public class Building {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building(String name, Set<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public Building(Building building) {


    }

    public Building() {
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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
