package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.InformationRepository;
import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.Information;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.InformationCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class InformationService implements InformationCrudService {

    private final InformationRepository informationRepository;

    @Autowired
    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public Information create(Information information){
        return informationRepository.save(information);
    }
    public Information update(Information information, UUID id){
        if(!informationRepository.existsById(id)) {
            throw new EntityExistsException("Information with id:'"+ information.getId() +"' doesn't exists");
        }
        return informationRepository.save(information);
    }
    @Override
    public void removeById(UUID id) {
        informationRepository.deleteById(id);
    }
    @Override
    public void remove(Information information) {
        informationRepository.delete(information);
    }

    @Override
    public List<Information> getAll() {
        return informationRepository.findAll();
    }
    @Override
    public Information getById(UUID id) {
        return informationRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("Information with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return informationRepository.existsById(id);
    }

}
