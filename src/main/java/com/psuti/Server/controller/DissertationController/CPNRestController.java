package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.CPN;
import com.psuti.Server.service.DissertationService.RestService.CPNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/cpn")
@RestController
public class CPNRestController {
    private final CPNService cpnService;
    @Autowired
    public CPNRestController(CPNService cpnService){
        this.cpnService = cpnService;
    }
    @GetMapping
    public List<CPN> getAll(){return cpnService.getAll();}
    @GetMapping("/{id}")
    public CPN getById(@PathVariable("id") UUID id){
        return cpnService.getById(id);
    }
    @PutMapping("/{id}")
    public CPN update(CPN cpn, @PathVariable("id") UUID id){
        return cpnService.update(cpn, id);
    }
    @PostMapping
    public CPN create(CPN cpn){
        return cpnService.create(cpn);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        cpnService.removeById(id);
    }

}
