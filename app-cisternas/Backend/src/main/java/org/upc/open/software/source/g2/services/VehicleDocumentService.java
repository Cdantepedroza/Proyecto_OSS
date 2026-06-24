package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.VehicleDocumentResponse;

import java.util.List;

public interface VehicleDocumentService {
    List<VehicleDocumentResponse> getVehicleDocuments();
}
