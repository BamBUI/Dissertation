package com.psuti.Server.service.DissertationService.RestService.DissertationCrudService;

import com.psuti.Server.entity.DissertationEntityes.GroupList;

import java.util.List;
import java.util.UUID;

public interface GroupListCrudService {
    GroupList create(GroupList groupList);
    GroupList update(GroupList groupList, UUID id);
    void removeById(UUID id);
    void remove(GroupList additionalPart);
    List<GroupList> getAll();
    GroupList getById(UUID id);
    boolean existsById(UUID id);
}
