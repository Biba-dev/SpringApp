package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController // a Spring stereotype to mark a class as a rest service
@CrossOrigin
@RequestMapping("/api/rooms")
// used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/heaters will be handle by this controller)
@Transactional // used to delegate a transaction opening to Spring.
public class RoomController {
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;
    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }


    @GetMapping // send list of rooms
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    //read a room
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    //switch the room windows (OPEN to CLOSED or inverse)
    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchWindowStatus(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (int i=0;i<room.getWindow().size();i++){
            Window window = room.getWindow().get(i);
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }
        return new RoomDto(room);
    }

    //switch the room heaters (ON to OFF or inverse)
    @PutMapping(path = "/{id}/switchHeaters")
    public RoomDto switchHeatersStatus(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (int i=0;i<room.getHeaters().size();i++){
            Heater heater = room.getHeaters().get(i);
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
        return new RoomDto(room);
    }

    //Add a room
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        // RoomDto must always contain the Room
        Room room = roomDao.getOne(dto.getId());

        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName(), dto.getWindow(), dto.getHeaters(), dto.getBuilding(), dto.getCurrenttmp(), dto.getTmp()));
        } else {
            room = roomDao.getOne(dto.getId());
            room.setFloor(dto.getFloor());
            room.setCurrenttmp(dto.getCurrenttmp());
            room.setTmp(dto.getTmp());
            room.setWindow(dto.getWindow());
            room.setHeaters(dto.getHeaters());
            room.setName(dto.getName());

        }
        return new RoomDto(room);
    }

    //delete a room
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}
