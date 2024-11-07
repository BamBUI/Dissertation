package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.GroupListRepository;
import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.GroupList;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.GroupListCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service

public class GroupListService implements GroupListCrudService {
    private final GroupListRepository groupListRepository;

    @Autowired
    public GroupListService(GroupListRepository groupListRepository) {
        this.groupListRepository = groupListRepository;
    }

    public GroupList create(GroupList groupList){
        return groupListRepository.save(groupList);
    }
    public GroupList update(GroupList groupList, UUID id){
        if(!groupListRepository.existsById(id)) {
            throw new EntityExistsException("GroupList with id:'"+ groupList.getId() +"' doesn't exists");
        }
        return groupListRepository.save(groupList);
    }
    @Override
    public void removeById(UUID id) {
        groupListRepository.deleteById(id);
    }
    @Override
    public void remove(GroupList groupList) {
        groupListRepository.delete(groupList);
    }

    @Override
    public List<GroupList> getAll() {
        return groupListRepository.findAll();
    }
    @Override
    public GroupList getById(UUID id) {
        return groupListRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("GroupList with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return groupListRepository.existsById(id);
    }
}
