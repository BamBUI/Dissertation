package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.Wire;
import com.psuti.Server.service.DissertationService.RestService.WireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/wire")
@RestController
public class WireRestController {
    private final WireService wireService;
    @Autowired
    public WireRestController(WireService wireService){
        this.wireService = wireService;
    }
    @GetMapping
    public List<Wire> getAll(){return wireService.getAll();}
    @GetMapping("/{id}")
    public Wire getById(@PathVariable("id") UUID id){
        return wireService.getById(id);
    }
    @PutMapping("/{id}")
    public Wire update(Wire wire, @PathVariable("id") UUID id){
        return wireService.update(wire, id);
    }
    @PostMapping
    public Wire create(Wire wire){
        return wireService.create(wire);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        wireService.removeById(id);
    }

}
