package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

import org.upc.open.software.source.g2.models.Zone;
import org.upc.open.software.source.g2.models.responses.ZoneResponse;
import org.upc.open.software.source.g2.services.ZoneService;

@ApplicationScoped
public class ZoneServiceImpl implements ZoneService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public ZoneServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<ZoneResponse> getZones() {
        return entityManager.get()
                .createQuery("select z from Zone z order by z.id", Zone.class)
                .getResultList()
                .stream()
                .map(zone -> new ZoneResponse(
                        zone.getId(),
                        zone.getNombre(),
                        zone.getEstado()
                ))
                .toList();
    }
}
