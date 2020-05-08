package org.janine.jian.securityjwtapp.controller;

import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysResource;
import org.janine.jian.securityjwtapp.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysResourceController {
    @Autowired
    public SysResourceService sysResourceService;

    @GetMapping("/sys/resource")
    public List<SysResource> findAll(){
        return sysResourceService.findAll();
    }

    @GetMapping("/sys/resource/findAllByPage")
    public List<SysResource> findAllByPage(
    		@PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable pageable){
        return sysResourceService.findAllByPage(pageable);
    }
    
    @GetMapping("/sys/resource/{id}")
    public SysResource findOne(@PathVariable("id") int id){
        return sysResourceService.findOne(id);
    }

    @PostMapping("/sys/resource")
    public void insert(@RequestBody SysResource sysResource){
        sysResourceService.insert(sysResource);
    }

    @PutMapping("/sys/resource")
    public void update(@RequestBody SysResource sysResource){
        sysResourceService.update(sysResource);
    }

    @DeleteMapping("/sys/resource/{id}")
    public void delete(@PathVariable("id") int id){
        sysResourceService.delete(id);
    }
}
