package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.Information;

import java.util.List;
import java.util.UUID;

public interface InformationCrudService {
    Information create(Information information);
    Information update(Information information, UUID id);
    void removeById(UUID id);
    void remove(Information information);
    List<Information> getAll();
    Information getById(UUID id);
    boolean existsById(UUID id);
}
