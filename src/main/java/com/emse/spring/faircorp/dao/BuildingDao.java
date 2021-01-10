package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuildingDao extends JpaRepository<Building, Long>, BuildingDaoCustom {
    @Modifying
    @Query("delete from Building b where b.id =:buildingId")
    void deleteBuilding(@Param("buildingId") Long id);
}
