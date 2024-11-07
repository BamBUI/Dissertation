package com.psuti.Server.controller.DissertationController;

import com.psuti.Server.entity.DissertationEntityes.Covering;
import com.psuti.Server.service.DissertationService.RestService.CoveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/covering")
@RestController
public class CoveringRestController {

    private final CoveringService coveringService;
    @Autowired
    public CoveringRestController(CoveringService coveringService){
        this.coveringService = coveringService;
    }
    @GetMapping
    public List<Covering> getAll(){return coveringService.getAll();}
    @GetMapping("/{id}")
    public Covering getById(@PathVariable("id") UUID id){
        return coveringService.getById(id);
    }
    @PutMapping("/{id}")
    public Covering update(Covering covering, @PathVariable("id") UUID id){
        return coveringService.update(covering, id);
    }
    @PostMapping
    public Covering create(Covering covering){
        return coveringService.create(covering);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        coveringService.removeById(id);
    }

}
