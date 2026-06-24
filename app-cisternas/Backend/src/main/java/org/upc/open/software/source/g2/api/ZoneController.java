package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.ZoneResponse;
import org.upc.open.software.source.g2.services.ZoneService;

@RequiredArgsConstructor
@Path("/zones")
public class ZoneController {

    private final ZoneService zoneService;

    @GET
    public List<ZoneResponse> getZones() {
        return zoneService.getZones();
    }
}
