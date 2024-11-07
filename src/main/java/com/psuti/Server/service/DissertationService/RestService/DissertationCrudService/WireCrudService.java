package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.Wire;

import java.util.List;
import java.util.UUID;

public interface WireCrudService {

    Wire create(Wire wire);
    Wire update(Wire wire, UUID id);
    void removeById(UUID id);
    void remove(Wire wire);
    List<Wire> getAll();
    Wire getById(UUID id);
    boolean existsById(UUID id);
}
