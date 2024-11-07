package com.psuti.Server.controller.DissertationController;

import com.psuti.Server.entity.DissertationEntityes.Connector;
import com.psuti.Server.service.DissertationService.RestService.ConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/сonnector")
@RestController
public class ConnectorController {

    private final ConnectorService сonnectorService;
    @Autowired
    public ConnectorController(ConnectorService connectorService){
        this.сonnectorService = connectorService;
    }
    @GetMapping
    public List<Connector> getAll(){return сonnectorService.getAll();}
    @GetMapping("/{id}")
    public Connector getById(@PathVariable("id") UUID id){
        return сonnectorService.getById(id);
    }
    @PutMapping("/{id}")
    public Connector update(Connector connector, @PathVariable("id") UUID id){
        return сonnectorService.update(connector, id);
    }
    @PostMapping
    public Connector create(Connector connector){
        return сonnectorService.create(connector);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        сonnectorService.removeById(id);
    }

}
