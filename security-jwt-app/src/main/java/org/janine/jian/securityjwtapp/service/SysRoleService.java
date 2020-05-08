package org.janine.jian.securityjwtapp.service;

import java.util.ArrayList;
import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysRole;
import org.janine.jian.securityjwtapp.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
	@Autowired
    public SysRoleRepository sysRoleRepository;

    public List<SysRole> findAll(){
    	Iterable<SysRole> iterable = sysRoleRepository.findAll();
    	List<SysRole> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
    
    public List<SysRole> findAllByPage(Pageable pageable){
        return sysRoleRepository.findAll(pageable).getContent();
    }

    public SysRole findOne(int id){
        return sysRoleRepository.findById(id).get();
    }

    public void insert(SysRole sysRole){
    	sysRoleRepository.save(sysRole);
    }

    public void update(SysRole sysRole){
    	sysRoleRepository.save(sysRole);
    }

    public void delete(int id){
    	sysRoleRepository.deleteById(id);
    }
}
