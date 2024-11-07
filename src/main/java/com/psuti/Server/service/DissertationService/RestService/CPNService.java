package com.psuti.Server.service.DissertationService.RestService;


import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.CPNRepository;
import com.psuti.Server.entity.DissertationEntityes.CPN;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.CPNCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class CPNService implements CPNCrudService {
    private final CPNRepository cpnRepository;

    @Autowired
    public CPNService(CPNRepository cpnRepository) {
        this.cpnRepository = cpnRepository;
    }

    public CPN create(CPN cpn){
        return cpnRepository.save(cpn);
    }
    public CPN update(CPN cpn, UUID id){
        if(!cpnRepository.existsById(id)) {
            throw new EntityExistsException("CPN with id:'"+ cpn.getId() +"' doesn't exists");
        }
        return cpnRepository.save(cpn);
    }
    @Override
    public void removeById(UUID id) {
        cpnRepository.deleteById(id);
    }
    @Override
    public void remove(CPN cpn) {
        cpnRepository.delete(cpn);
    }

    @Override
    public List<CPN> getAll() {
        return cpnRepository.findAll();
    }
    @Override
    public CPN getById(UUID id) {
        return cpnRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("CPN with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return cpnRepository.existsById(id);
    }
}
