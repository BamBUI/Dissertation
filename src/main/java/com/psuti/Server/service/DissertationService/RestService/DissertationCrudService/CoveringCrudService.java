package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.Covering;

import java.util.List;
import java.util.UUID;

public interface CoveringCrudService {
    Covering create(Covering covering);
    Covering update(Covering covering, UUID id);
    void removeById(UUID id);
    void remove(Covering covering);
    List<Covering> getAll();
    Covering getById(UUID id);
    boolean existsById(UUID id);
}
