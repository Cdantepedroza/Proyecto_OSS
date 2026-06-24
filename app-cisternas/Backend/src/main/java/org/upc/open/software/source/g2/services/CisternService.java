package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.CisternResponse;

import java.util.List;

public interface CisternService {
    List<CisternResponse> getCisterns();
}
