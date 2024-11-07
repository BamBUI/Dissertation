package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.Connector;

import java.util.List;
import java.util.UUID;

public interface ConnectorCrudService {
    Connector create(Connector connector);
    Connector update(Connector connector, UUID id);
    void removeById(UUID id);
    void remove(Connector additionalPart);
    List<Connector> getAll();
    Connector getById(UUID id);
    boolean existsById(UUID id);
}
