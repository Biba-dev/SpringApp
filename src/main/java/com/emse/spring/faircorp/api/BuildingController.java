package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Building;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;
    private final RoomDao roomDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
    }

    @GetMapping // send building list
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // (6)
    }

    // read a building
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null); // (7)
    }

    //add a building
    @PostMapping // (8)
    public BuildingDto create(@RequestBody BuildingDto dto) {
        // BuildingDto must always contain the window room

        Building building = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName(), dto.getRooms()));
        } else {
            building = buildingDao.getOne(dto.getId());  // (9)
            building.setRooms(dto.getRooms());
        }
        return new BuildingDto(building);
    }

    //delete a building and all its rooms and all its windows and heaters
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }
}
