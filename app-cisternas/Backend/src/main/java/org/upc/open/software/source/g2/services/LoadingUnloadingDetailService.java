package org.upc.open.software.source.g2.services;

import java.util.List;
import org.upc.open.software.source.g2.models.responses.LoadingUnloadingDetailResponse;

public interface LoadingUnloadingDetailService {

    List<LoadingUnloadingDetailResponse> getLoadingUnloadingDetails();
}
