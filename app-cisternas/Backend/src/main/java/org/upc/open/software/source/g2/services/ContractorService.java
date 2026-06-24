package org.upc.open.software.source.g2.services;

import java.util.List;
import org.upc.open.software.source.g2.models.responses.ContractorResponse;

public interface ContractorService {

    List<ContractorResponse> getContractors();
}
