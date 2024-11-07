package com.psuti.Server.service.DissertationService.RestService;

import com.psuti.Server.dao.DissertationDao.AdditionalPartRepository;
import com.psuti.Server.dao.DissertationDao.ConnectorRepository;
import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.Connector;
import com.psuti.Server.service.DissertationService.RestService.DissertationCrudService.ConnectorCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@Service
public class ConnectorService implements ConnectorCrudService {

    private final ConnectorRepository connectorRepository;

    @Autowired
    public ConnectorService(ConnectorRepository connectorRepository) {
        this.connectorRepository = connectorRepository;
    }

    public Connector create(Connector connector){
        return connectorRepository.save(connector);
    }
    public Connector update(Connector connector, UUID id){
        if(!connectorRepository.existsById(id)) {
            throw new EntityExistsException("Connector with id:'"+ connector.getId() +"' doesn't exists");
        }
        return connectorRepository.save(connector);
    }
    @Override
    public void removeById(UUID id) {
        connectorRepository.deleteById(id);
    }
    @Override
    public void remove(Connector connector) {
        connectorRepository.delete(connector);
    }

    @Override
    public List<Connector> getAll() {
        return connectorRepository.findAll();
    }
    @Override
    public Connector getById(UUID id) {
        return connectorRepository.findById(id).orElseThrow(()->{
            throw new EntityExistsException("Connector with id: " + id + " doesn't exists");
        });
    }
    @Override
    public boolean existsById(UUID id) {
        return connectorRepository.existsById(id);
    }
}
