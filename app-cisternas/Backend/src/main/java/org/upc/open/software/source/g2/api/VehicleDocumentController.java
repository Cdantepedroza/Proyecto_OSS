package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.VehicleDocumentResponse;
import org.upc.open.software.source.g2.services.VehicleDocumentService;

@RequiredArgsConstructor
@Path("/minaya/vehiculos")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleDocumentController {

    public final VehicleDocumentService vehicleDocumentService;

    @GET
    public List<VehicleDocumentResponse> getVehicleDocuments() {
        return vehicleDocumentService.getVehicleDocuments();
    }
}
