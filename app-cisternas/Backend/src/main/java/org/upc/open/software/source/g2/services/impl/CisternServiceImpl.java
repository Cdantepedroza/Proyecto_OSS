package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.upc.open.software.source.g2.models.persistence.Cistern;
import org.upc.open.software.source.g2.models.responses.CisternResponse;
import org.upc.open.software.source.g2.services.CisternService;

import java.util.List;

@ApplicationScoped
public class CisternServiceImpl implements CisternService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public CisternServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<CisternResponse> getCisterns() {
        return entityManager.get()
                .createQuery("select c from Cistern c order by c.id", Cistern.class)
                .getResultList()
                .stream()
                .map(cistern -> new CisternResponse(
                        cistern.getId(),
                        cistern.getPlaca(),
                        cistern.getCapacidadM3(),
                        cistern.getEstadoOperativo(),
                        cistern.getDisponible(),
                        cistern.getFechaRegistro()
                ))
                .toList();
    }
}
