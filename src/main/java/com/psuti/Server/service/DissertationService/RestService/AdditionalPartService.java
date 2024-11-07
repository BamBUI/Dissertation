package com.psuti.Server.service.DissertationService.RestService;


import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.AdditionalPartCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class AdditionalPartService implements AdditionalPartCrudService {
    private final AdditionalPartRepository additionalPartRepository;

    @Autowired
    public AdditionalPartService(AdditionalPartRepository additionalPartRepository) {
        this.additionalPartRepository = additionalPartRepository;
    }

    public AdditionalPart create(AdditionalPart additionalPart){
        return additionalPartRepository.save(additionalPart);
    }
    public AdditionalPart update(AdditionalPart additionalPart, UUID id){
        if(!additionalPartRepository.existsById(id)) {
            throw new EntityExistsException("AdditionalPart with id:'"+ additionalPart.getId() +"' doesn't exists");
        }
        return additionalPartRepository.save(additionalPart);
    }
    @Override
    public void removeById(UUID id) {
        additionalPartRepository.deleteById(id);
    }
    @Override
    public void remove(AdditionalPart additionalPart) {
        additionalPartRepository.delete(additionalPart);
    }

    @Override
    public List<AdditionalPart> getAll() {
        return additionalPartRepository.findAll();
    }
    @Override
    public AdditionalPart getById(UUID id) {
        return additionalPartRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("AdditionalPart with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return additionalPartRepository.existsById(id);
    }

}
