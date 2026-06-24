package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.upc.open.software.source.g2.models.persistence.LoadingUnloadingDetail;
import org.upc.open.software.source.g2.models.responses.LoadingUnloadingDetailResponse;
import org.upc.open.software.source.g2.services.LoadingUnloadingDetailService;

@ApplicationScoped
public class LoadingUnloadingDetailServiceImpl implements LoadingUnloadingDetailService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public LoadingUnloadingDetailServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<LoadingUnloadingDetailResponse> getLoadingUnloadingDetails() {
        return entityManager.get()
                .createQuery("""
                        select d
                        from LoadingUnloadingDetail d
                        join fetch d.viaje
                        order by d.id
                        """, LoadingUnloadingDetail.class)
                .getResultList()
                .stream()
                .map(detail -> new LoadingUnloadingDetailResponse(
                        detail.getId(),
                        detail.getLecturaInicial(),
                        detail.getLecturaFinal(),
                        detail.getVolumenDistribuidoM3(),
                        detail.getTipoLiquido(),
                        detail.getCloroResidualMgl(),
                        detail.getViaje().getId()
                ))
                .toList();
    }
}
