package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.SubAssembly;
import com.psuti.Server.service.DissertationService.RestService.SubAssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/subAssembly")
@RestController
public class SubAssemblyRestController {
    private final SubAssemblyService specialWireService;
    @Autowired
    public SubAssemblyRestController(SubAssemblyService specialWireService){
        this.specialWireService = specialWireService;
    }
    @GetMapping
    public List<SubAssembly> getAll(){return specialWireService.getAll();}
    @GetMapping("/{id}")
    public SubAssembly getById(@PathVariable("id") UUID id){
        return specialWireService.getById(id);
    }
    @PutMapping("/{id}")
    public SubAssembly update(SubAssembly subAssembly, @PathVariable("id") UUID id){
        return specialWireService.update(subAssembly, id);
    }
    @PostMapping
    public SubAssembly create(SubAssembly subAssembly){
        return specialWireService.create(subAssembly);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        specialWireService.removeById(id);
    }

}
