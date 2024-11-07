package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.SupportPartRepository;
import com.psuti.Server.entity.DissertationEntityes.SupportPart;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.SupportPartCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class SupportPartService implements SupportPartCrudService {
    private final SupportPartRepository supportPartRepository;

    @Autowired
    public SupportPartService(SupportPartRepository supportPartRepository) {
        this.supportPartRepository = supportPartRepository;
    }

    public SupportPart create(SupportPart supportPart){
        return supportPartRepository.save(supportPart);
    }
    public SupportPart update(SupportPart supportPart, UUID id){
        if(!supportPartRepository.existsById(id)) {
            throw new EntityExistsException("SupportPart with id:'"+ supportPart.getId() +"' doesn't exists");
        }
        return supportPartRepository.save(supportPart);
    }
    @Override
    public void removeById(UUID id) {
        supportPartRepository.deleteById(id);
    }
    @Override
    public void remove(SupportPart supportPart) {
        supportPartRepository.delete(supportPart);
    }

    @Override
    public List<SupportPart> getAll() {
        return supportPartRepository.findAll();
    }
    @Override
    public SupportPart getById(UUID id) {
        return supportPartRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("SupportPart with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return supportPartRepository.existsById(id);
    }

}
