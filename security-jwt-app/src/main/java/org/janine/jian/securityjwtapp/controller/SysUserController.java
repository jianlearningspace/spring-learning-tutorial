package org.janine.jian.securityjwtapp.controller;

import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysUser;
import org.janine.jian.securityjwtapp.service.SysUserService;
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
public class SysUserController {
    @Autowired
    public SysUserService sysUserService;

    @GetMapping("/sys/user")
    public List<SysUser> findAll(){
        return sysUserService.findAll();
    }
    
    @GetMapping("/sys/user/findAllByPage")
    public List<SysUser> findAllByPage(
    		@PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable pageable){
        return sysUserService.findAllByPage(pageable);
    }

    @GetMapping("/sys/user/{id}")
    public SysUser findOne(@PathVariable("id") int id){
        return sysUserService.findOne(id);
    }

    @PostMapping("/sys/user")
    public void insert(@RequestBody SysUser sysUser){
        sysUserService.insert(sysUser);
    }

    @PutMapping("/sys/user")
    public void update(@RequestBody SysUser sysUser){
        sysUserService.update(sysUser);
    }

    @DeleteMapping("/sys/user/{id}")
    public void delete(@PathVariable("id") int id){
        sysUserService.delete(id);
    }
}
