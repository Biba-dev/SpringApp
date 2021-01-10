package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/heaters")
// used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/heaters will be handle by this controller)
@Transactional // used to delegate a transaction opening to Spring.
public class HeaterController {
    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    //send heaters list
    @GetMapping // (5)
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }

    // read a heater
    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }


    //add a heater
    @PostMapping // (8)
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getOne(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(room, dto.getName(), dto.getDefaultPowerInWatt(), dto.getHeaterStatus()));
        } else {
            heater = heaterDao.getOne(dto.getId());  // (9)
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setDefaultPowerInWatt(dto.getDefaultPowerInWatt());
        }
        return new HeaterDto(heater);
    }

    //delete a heater
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
