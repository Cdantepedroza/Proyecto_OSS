package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.ZoneResponse;

import java.util.List;

public interface ZoneService {
    List<ZoneResponse> getZones();
}
