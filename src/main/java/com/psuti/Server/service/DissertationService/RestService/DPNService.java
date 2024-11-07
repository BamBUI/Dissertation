package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.DPNRepository;
import com.psuti.Server.entity.DissertationEntityes.DPN;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.DPNCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class DPNService implements DPNCrudService {

    private final DPNRepository dpnRepository;

    @Autowired
    public DPNService(DPNRepository dpnRepository) {
        this.dpnRepository = dpnRepository;
    }

    public DPN create(DPN dpn){
        return dpnRepository.save(dpn);
    }

    public DPN update(DPN additionalPart, UUID id){
        if(!dpnRepository.existsById(id)) {
            throw new EntityExistsException("DPN with id:'"+ additionalPart.getId() +"' doesn't exists");
        }
        return dpnRepository.save(additionalPart);
    }

    @Override
    public void removeById(UUID id) {
        dpnRepository.deleteById(id);
    }

    @Override
    public void remove(DPN additionalPart) {
        dpnRepository.delete(additionalPart);
    }

    @Override
    public List<DPN> getAll() {
        return dpnRepository.findAll();
    }

    @Override
    public DPN getById(UUID id) {
        return dpnRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("DPN with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return dpnRepository.existsById(id);
    }
}
