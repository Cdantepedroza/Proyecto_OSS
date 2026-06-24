package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.LoadingUnloadingDetailResponse;
import org.upc.open.software.source.g2.services.LoadingUnloadingDetailService;

@Path("/loadUnload")
@RequiredArgsConstructor
public class LoadingUnloadingController {

    private final LoadingUnloadingDetailService loadUnloadSerice;

    @GET
    @Path("/loading-unloading-details")
    public List<LoadingUnloadingDetailResponse> getLoadingUnloadingDetails() {
        return loadUnloadSerice.getLoadingUnloadingDetails();
    }
}
