package org.janine.jian.securityjwtapp.controller;

import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysPermission;
import org.janine.jian.securityjwtapp.service.SysPermissionService;
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
public class SysPermissionController {
    @Autowired
    public SysPermissionService sysPermissionService;

    @GetMapping("/sys/permission")
    public List<SysPermission> findAll(){
        return sysPermissionService.findAll();
    }
    
    @GetMapping("/sys/permission/findAllByPage")
    public List<SysPermission> findAllByPage(
    		@PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable pageable){
        return sysPermissionService.findAllByPage(pageable);
    }

    @GetMapping("/sys/permission/{id}")
    public SysPermission findOne(@PathVariable("id") int id){
        return sysPermissionService.findOne(id);
    }

    @PostMapping("/sys/permission")
    public void insert(@RequestBody SysPermission sysPermission){
        sysPermissionService.insert(sysPermission);
    }

    @PutMapping("/sys/permission")
    public void update(@RequestBody SysPermission sysPermission){
        sysPermissionService.update(sysPermission);
    }

    @DeleteMapping("/sys/permission/{id}")
    public void delete(@PathVariable("id") int id){
        sysPermissionService.delete(id);
    }
}
