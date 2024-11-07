package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.CoveringRepository;
import com.psuti.Server.entity.DissertationEntityes.Covering;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.CoveringCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class CoveringService implements CoveringCrudService {

    private final CoveringRepository coveringRepository;

    @Autowired
    public CoveringService(CoveringRepository coveringRepository) {
        this.coveringRepository = coveringRepository;
    }

    public Covering create(Covering covering){
        return coveringRepository.save(covering);
    }
    public Covering update(Covering covering, UUID id){
        if(!coveringRepository.existsById(id)) {
            throw new EntityExistsException("Covering with id:'"+ covering.getId() +"' doesn't exists");
        }
        return coveringRepository.save(covering);
    }
    @Override
    public void removeById(UUID id) {
        coveringRepository.deleteById(id);
    }
    @Override
    public void remove(Covering covering) {
        coveringRepository.delete(covering);
    }

    @Override
    public List<Covering> getAll() {
        return coveringRepository.findAll();
    }
    @Override
    public Covering getById(UUID id) {
        return coveringRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("Covering with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return coveringRepository.existsById(id);
    }
}
