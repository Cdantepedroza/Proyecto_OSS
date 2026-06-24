package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.TripResponse;
import org.upc.open.software.source.g2.services.TripService;

@Path("/minaya/viajes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GET
    public List<TripResponse> getTrips() {
        return tripService.getTrips();
    }
}
