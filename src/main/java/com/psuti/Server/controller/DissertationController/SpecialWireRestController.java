package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.SpecialWire;
import com.psuti.Server.service.DissertationService.RestService.SpecialWireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/specialWire")
@RestController
public class SpecialWireRestController {
    private final SpecialWireService specialWireService;
    @Autowired
    public SpecialWireRestController(SpecialWireService specialWireService){
        this.specialWireService = specialWireService;
    }
    @GetMapping
    public List<SpecialWire> getAll(){return specialWireService.getAll();}
    @GetMapping("/{id}")
    public SpecialWire getById(@PathVariable("id") UUID id){
        return specialWireService.getById(id);
    }
    @PutMapping("/{id}")
    public SpecialWire update(SpecialWire specialWire, @PathVariable("id") UUID id){
        return specialWireService.update(specialWire, id);
    }
    @PostMapping
    public SpecialWire create(SpecialWire specialWire){
        return specialWireService.create(specialWire);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        specialWireService.removeById(id);
    }

}
