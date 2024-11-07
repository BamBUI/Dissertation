package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.User;

import java.util.List;
import java.util.UUID;

public interface AdditionalPartCrudService {
    AdditionalPart create(AdditionalPart additionalPart);
    AdditionalPart update(AdditionalPart additionalPart, UUID id);
    void removeById(UUID id);
    void remove(AdditionalPart additionalPart);
    List<AdditionalPart> getAll();
    AdditionalPart getById(UUID id);
    boolean existsById(UUID id);
}
