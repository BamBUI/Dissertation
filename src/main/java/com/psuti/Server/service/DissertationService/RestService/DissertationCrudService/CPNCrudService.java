package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.CPN;

import java.util.List;
import java.util.UUID;

public interface CPNCrudService {
    CPN create(CPN cpn);
    CPN update(CPN cpn, UUID id);
    void removeById(UUID id);
    void remove(CPN cpn);
    List<CPN> getAll();
    CPN getById(UUID id);
    boolean existsById(UUID id);
}
