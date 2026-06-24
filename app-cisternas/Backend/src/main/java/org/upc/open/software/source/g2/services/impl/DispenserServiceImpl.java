package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.upc.open.software.source.g2.models.persistence.Dispenser;
import org.upc.open.software.source.g2.models.responses.DispenserResponse;
import org.upc.open.software.source.g2.services.DispenserService;

import java.util.List;

@ApplicationScoped
public class DispenserServiceImpl implements DispenserService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public DispenserServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<DispenserResponse> getDispensers() {
        return entityManager.get()
                .createQuery("select d from Dispenser d order by d.id", Dispenser.class)
                .getResultList()
                .stream()
                .map(dispenser -> new DispenserResponse(
                        dispenser.getId(),
                        dispenser.getNombre(),
                        dispenser.getEstado()
                ))
                .toList();
    }
}
