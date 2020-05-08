package org.janine.jian.securityjwtapp.service;

import java.util.ArrayList;
import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysUser;
import org.janine.jian.securityjwtapp.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    public SysUserRepository sysUserRepository;

    public List<SysUser> findAll(){
    	Iterable<SysUser> iterable = sysUserRepository.findAll();
    	List<SysUser> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
    
    public List<SysUser> findAllByPage(Pageable pageable){
        return sysUserRepository.findAll(pageable).getContent();
    }

    public SysUser findOne(int id){
        return sysUserRepository.findById(id).get();
    }
    
    public SysUser findByUserName(String username){
        return sysUserRepository.findByUsername(username);
    }

    public void insert(SysUser sysUser){
    	sysUserRepository.save(sysUser);
    }

    public void update(SysUser sysUser){
    	sysUserRepository.save(sysUser);
    }

    public void delete(int id){
    	sysUserRepository.deleteById(id);
    }

}
