package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Light> findBuildingLights(Long id) {
        String jpql = "select l from Light l where l.room.building.id = :id ";
        return em.createQuery(jpql, Light.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Window> findBuildingWindows(Long id) {
        String jpql = "select w from Window w where w.room.building.id = :id ";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }
}
