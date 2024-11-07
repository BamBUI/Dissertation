package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.DPN;

import java.util.List;
import java.util.UUID;

public interface DPNCrudService {
    DPN create(DPN dpn);
    DPN update(DPN dpn, UUID id);
    void removeById(UUID id);
    void remove(DPN cpn);
    List<DPN> getAll();
    DPN getById(UUID id);
    boolean existsById(UUID id);
}
