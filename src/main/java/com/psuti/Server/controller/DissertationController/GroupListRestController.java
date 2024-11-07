package com.psuti.Server.controller.DissertationController;


import com.psuti.Server.entity.DissertationEntityes.GroupList;
import com.psuti.Server.service.DissertationService.RestService.GroupListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/groupList")
@RestController
public class GroupListRestController {
    private final GroupListService groupListService;
    @Autowired
    public GroupListRestController(GroupListService groupListService){
        this.groupListService = groupListService;
    }
    @GetMapping
    public List<GroupList> getAll(){return groupListService.getAll();}
    @GetMapping("/{id}")
    public GroupList getById(@PathVariable("id") UUID id){
        return groupListService.getById(id);
    }
    @PutMapping("/{id}")
    public GroupList update(GroupList groupList, @PathVariable("id") UUID id){
        return groupListService.update(groupList, id);
    }
    @PostMapping
    public GroupList create(GroupList groupList){
        return groupListService.create(groupList);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id){
        groupListService.removeById(id);
    }

}
