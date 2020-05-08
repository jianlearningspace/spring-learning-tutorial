package org.janine.jian.securityjwtapp.service;

import java.util.ArrayList;
import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysPermission;
import org.janine.jian.securityjwtapp.repository.SysPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionService {
	@Autowired
    public SysPermissionRepository sysPermissionRepository;

    public List<SysPermission> findAll(){
    	Iterable<SysPermission> iterable = sysPermissionRepository.findAll();
    	List<SysPermission> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
    
    public List<SysPermission> findAllByPage(Pageable pageable){
        return sysPermissionRepository.findAll(pageable).getContent();
    }

    public SysPermission findOne(int id){
        return sysPermissionRepository.findById(id).get();
    }

    public void insert(SysPermission sysPermission){
    	sysPermissionRepository.save(sysPermission);
    }

    public void update(SysPermission sysPermission){
    	sysPermissionRepository.save(sysPermission);
    }

    public void delete(int id){
    	sysPermissionRepository.deleteById(id);
    }
}
