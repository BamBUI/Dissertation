package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.Information;
import com.psuti.Server.service.DissertationService.RestService.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/information")
@RestController
public class InformationRestController {
    private final InformationService informationService;
    @Autowired
    public InformationRestController(InformationService informationService){
        this.informationService = informationService;
    }
    @GetMapping
    public List<Information> getAll(){return informationService.getAll();}
    @GetMapping("/{id}")
    public Information getById(@PathVariable("id") UUID id){
        return informationService.getById(id);
    }
    @PutMapping("/{id}")
    public Information update(Information information, @PathVariable("id") UUID id){
        return informationService.update(information, id);
    }
    @PostMapping
    public Information create(Information information){
        return informationService.create(information);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        informationService.removeById(id);
    }

}
