package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.upc.open.software.source.g2.models.Contractor;
import org.upc.open.software.source.g2.models.responses.ContractorResponse;
import org.upc.open.software.source.g2.services.ContractorService;

@ApplicationScoped
public class ContractorServiceImpl implements ContractorService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public ContractorServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<ContractorResponse> getContractors() {
        return entityManager.get()
                .createQuery("select c from Contractor c order by c.id", Contractor.class)
                .getResultList()
                .stream()
                .map(contractor -> new ContractorResponse(
                        contractor.getId(),
                        contractor.getRazonSocial(),
                        contractor.getRuc(),
                        contractor.getEstado()
                ))
                .toList();
    }
}
