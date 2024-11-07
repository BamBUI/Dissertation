package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.WireRepository;
import com.psuti.Server.entity.DissertationEntityes.Wire;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.WireCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service

public class WireService implements WireCrudService {
    private final WireRepository wireRepository;
    @Autowired
    public WireService(WireRepository wireRepository) {
        this.wireRepository = wireRepository;
    }
    public Wire create(Wire wire){
        return wireRepository.save(wire);
    }
    public Wire update(Wire wire, UUID id){
        if(!wireRepository.existsById(id)) {
            throw new EntityExistsException("Wire with id:'"+ wire.getId() +"' doesn't exists");
        }
        return wireRepository.save(wire);
    }
    @Override
    public void removeById(UUID id) {
        wireRepository.deleteById(id);
    }
    @Override
    public void remove(Wire wire) {
        wireRepository.delete(wire);
    }
    @Override
    public List<Wire> getAll() {
        return wireRepository.findAll();
    }
    @Override
    public Wire getById(UUID id) {
        return wireRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("Wire with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return wireRepository.existsById(id);
    }

}
