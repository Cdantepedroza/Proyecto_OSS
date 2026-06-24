package org.upc.open.software.source.g2.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.upc.open.software.source.g2.models.responses.DispenserResponse;
import org.upc.open.software.source.g2.services.DispenserService;

@Path("/dispenser")
public class DispenserController {

    private final DispenserService dispenserService;

    @Inject
    public DispenserController(DispenserService dispenserService) {
        this.dispenserService = dispenserService;
    }


    @GET
    @Path("/dispensers")
    public List<DispenserResponse> getDispensers() {
        return dispenserService.getDispensers();
    }
}
