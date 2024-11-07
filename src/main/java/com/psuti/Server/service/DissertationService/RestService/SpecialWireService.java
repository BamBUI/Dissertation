package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.InformationRepository;
import com.psuti.Server.dao.DissertationDao.SpecialWireRepository;
import com.psuti.Server.entity.DissertationEntityes.SpecialWire;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.SpecialWireCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class SpecialWireService implements SpecialWireCrudService {
    private final SpecialWireRepository specialWireRepository;

    @Autowired
    public SpecialWireService(SpecialWireRepository specialWireRepository) {
        this.specialWireRepository = specialWireRepository;
    }

    public SpecialWire create(SpecialWire specialWire){
        return specialWireRepository.save(specialWire);
    }
    public SpecialWire update(SpecialWire specialWire, UUID id){
        if(!specialWireRepository.existsById(id)) {
            throw new EntityExistsException("SpecialWire with id:'"+ specialWire.getId() +"' doesn't exists");
        }
        return specialWireRepository.save(specialWire);
    }
    @Override
    public void removeById(UUID id) {
        specialWireRepository.deleteById(id);
    }
    @Override
    public void remove(SpecialWire specialWire) {
        specialWireRepository.delete(specialWire);
    }

    @Override
    public List<SpecialWire> getAll() {
        return specialWireRepository.findAll();
    }
    @Override
    public SpecialWire getById(UUID id) {
        return specialWireRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("SpecialWire with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return specialWireRepository.existsById(id);
    }

}
