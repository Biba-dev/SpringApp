package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface BuildingDaoCustom {
    List<Light> findBuildingLights(Long id);

    List<Window> findBuildingWindows(Long id);
}
