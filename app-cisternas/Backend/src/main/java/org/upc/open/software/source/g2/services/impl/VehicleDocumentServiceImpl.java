package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.upc.open.software.source.g2.models.VehicleDocument;
import org.upc.open.software.source.g2.models.responses.VehicleDocumentResponse;
import org.upc.open.software.source.g2.services.VehicleDocumentService;

import java.util.List;

@ApplicationScoped
public class VehicleDocumentServiceImpl implements VehicleDocumentService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public VehicleDocumentServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<VehicleDocumentResponse> getVehicleDocuments() {
        return entityManager.get()
                .createQuery(
                        "select d from VehicleDocument d join fetch d.cisterna order by d.id",
                        VehicleDocument.class
                )
                .getResultList()
                .stream()
                .map(document -> new VehicleDocumentResponse(
                        document.getId(),
                        document.getTipoDocumento(),
                        document.getFechaEmision(),
                        document.getFechaVencimiento(),
                        document.getEstado(),
                        document.getCisterna().getId()
                ))
                .toList();
    }
}
