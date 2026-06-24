package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.CisternResponse;
import org.upc.open.software.source.g2.services.CisternService;

@Path("/minaya/cisternas")
@RequiredArgsConstructor
public class CisternController {
    private final CisternService cisterService;

    @GET
    public List<CisternResponse> getCisterns() {
        return cisterService.getCisterns();
    }
}
