package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.SupportPart;

import java.util.List;
import java.util.UUID;

public interface SupportPartCrudService {
    SupportPart create(SupportPart supportPart);
    SupportPart update(SupportPart supportPart, UUID id);
    void removeById(UUID id);
    void remove(SupportPart supportPart);
    List<SupportPart> getAll();
    SupportPart getById(UUID id);
    boolean existsById(UUID id);
}
