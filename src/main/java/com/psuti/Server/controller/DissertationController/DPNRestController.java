package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.DPN;
import com.psuti.Server.service.DissertationService.RestService.DPNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/dpn")
@RestController
public class DPNRestController {
    private final DPNService dpnService;
    @Autowired
    public DPNRestController(DPNService dpnService){
        this.dpnService = dpnService;
    }
    @GetMapping
    public List<DPN> getAll(){return dpnService.getAll();}
    @GetMapping("/{id}")
    public DPN getById(@PathVariable("id") UUID id){
        return dpnService.getById(id);
    }
    @PutMapping("/{id}")
    public DPN update(DPN dpn, @PathVariable("id") UUID id){
        return dpnService.update(dpn, id);
    }
    @PostMapping
    public DPN create(DPN dpn){
        return dpnService.create(dpn);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        dpnService.removeById(id);
    }

}
