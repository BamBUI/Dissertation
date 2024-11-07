package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.SubAssembly;

import java.util.List;
import java.util.UUID;

public interface SubAssemblyCrudService {
    SubAssembly create(SubAssembly subAssembly);
    SubAssembly update(SubAssembly subAssembly, UUID id);
    void removeById(UUID id);
    void remove(SubAssembly subAssembly);
    List<SubAssembly> getAll();
    SubAssembly getById(UUID id);
    boolean existsById(UUID id);
}
