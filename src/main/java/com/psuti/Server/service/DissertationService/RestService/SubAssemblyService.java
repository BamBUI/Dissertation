package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.SubAssemblyRepository;
import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.SubAssembly;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.SubAssemblyCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class SubAssemblyService implements SubAssemblyCrudService {

    private final SubAssemblyRepository subAssemblyRepository;

    @Autowired
    public SubAssemblyService(SubAssemblyRepository subAssemblyRepository) {
        this.subAssemblyRepository = subAssemblyRepository;
    }

    public SubAssembly create(SubAssembly subAssembly){
        return subAssemblyRepository.save(subAssembly);
    }
    public SubAssembly update(SubAssembly subAssembly, UUID id){
        if(!subAssemblyRepository.existsById(id)) {
            throw new EntityExistsException("SubAssembly with id:'"+ subAssembly.getId() +"' doesn't exists");
        }
        return subAssemblyRepository.save(subAssembly);
    }
    @Override
    public void removeById(UUID id) {
        subAssemblyRepository.deleteById(id);
    }
    @Override
    public void remove(SubAssembly subAssembly) {
        subAssemblyRepository.delete(subAssembly);
    }

    @Override
    public List<SubAssembly> getAll() {
        return subAssemblyRepository.findAll();
    }
    @Override
    public SubAssembly getById(UUID id) {
        return subAssemblyRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("SubAssembly with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return subAssemblyRepository.existsById(id);
    }

}
