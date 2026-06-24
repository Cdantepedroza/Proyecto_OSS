package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.TripResponse;

import java.util.List;

public interface TripService {

    List<TripResponse> getTrips();
}
