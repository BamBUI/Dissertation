package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.SpecialWire;

import java.util.List;
import java.util.UUID;

public interface SpecialWireCrudService {
    SpecialWire create(SpecialWire specialWire);
    SpecialWire update(SpecialWire specialWire, UUID id);
    void removeById(UUID id);
    void remove(SpecialWire specialWire);
    List<SpecialWire> getAll();
    SpecialWire getById(UUID id);
    boolean existsById(UUID id);
}
