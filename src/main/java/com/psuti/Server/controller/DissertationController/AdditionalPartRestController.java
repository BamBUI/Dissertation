package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.service.DissertationService.RestService.AdditionalPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/additionalPart")
@RestController
public class AdditionalPartRestController {

    private final AdditionalPartService additionalPartService;
    @Autowired
    public AdditionalPartRestController(AdditionalPartService additionalPartService){
        this.additionalPartService = additionalPartService;
    }
    @GetMapping
    public List<AdditionalPart> getAll(){return additionalPartService.getAll();}
    @GetMapping("/{id}")
    public AdditionalPart getById(@PathVariable("id") UUID id){
        return additionalPartService.getById(id);
    }
    @PutMapping("/{id}")
    public AdditionalPart update(AdditionalPart additionalPart, @PathVariable("id") UUID id){
        return additionalPartService.update(additionalPart, id);
    }
    @PostMapping
    public AdditionalPart create(AdditionalPart additionalPart){
        return additionalPartService.create(additionalPart);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        additionalPartService.removeById(id);
    }

}
