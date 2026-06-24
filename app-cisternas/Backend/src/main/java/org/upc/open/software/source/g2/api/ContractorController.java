package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.ContractorResponse;
import org.upc.open.software.source.g2.services.ContractorService;

@Path("/minaya/contratista")
@RequiredArgsConstructor
public class ContractorController {

    public final ContractorService contractorService;

    @GET
    public List<ContractorResponse> getContractors() {
        return contractorService.getContractors();
    }
}
