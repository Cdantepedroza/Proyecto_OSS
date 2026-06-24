package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.upc.open.software.source.g2.models.persistence.Trip;
import org.upc.open.software.source.g2.models.responses.TripResponse;
import org.upc.open.software.source.g2.services.TripService;

import java.util.List;

@ApplicationScoped
public class TripServiceImpl implements TripService {
    private final Instance<EntityManager> entityManager;

    @Inject
    public TripServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<TripResponse> getTrips() {
        return entityManager.get()
                .createQuery("""
                        select v
                        from Trip v
                        join fetch v.conductor
                        left join fetch v.ayudante
                        join fetch v.cisterna
                        join fetch v.surtidor
                        join fetch v.zona
                        join fetch v.contratista
                        order by v.id
                        """, Trip.class)
                .getResultList()
                .stream()
                .map(trip -> new TripResponse(
                        trip.getId(),
                        trip.getFecha(),
                        trip.getNumeroFolio(),
                        trip.getHoraInicio(),
                        trip.getHoraFin(),
                        trip.getEstadoViaje(),
                        trip.getEstadoFicha(),
                        trip.getObservacion(),
                        trip.getConductor().getId(),
                        trip.getAyudante() == null ? null : trip.getAyudante().getId(),
                        trip.getCisterna().getId(),
                        trip.getSurtidor().getId(),
                        trip.getZona().getId(),
                        trip.getContratista().getId(),
                        trip.getFechaCreacion()
                ))
                .toList();
    }
}
