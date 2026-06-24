package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.DispenserResponse;

import java.util.List;

public interface DispenserService {

    List<DispenserResponse> getDispensers();
}
