package org.janine.jian.securityjwtapp.service;

import java.util.ArrayList;
import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysResource;
import org.janine.jian.securityjwtapp.repository.SysResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SysResourceService {
	@Autowired
    public SysResourceRepository sysResourceRepository;

    public List<SysResource> findAll(){
    	Iterable<SysResource> iterable = sysResourceRepository.findAll();
    	List<SysResource> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
    
    public List<SysResource> findAllByPage(Pageable pageable){
        return sysResourceRepository.findAll(pageable).getContent();
    }

    public SysResource findOne(int id){
        return sysResourceRepository.findById(id).get();
    }

    public void insert(SysResource sysResource){
    	sysResourceRepository.save(sysResource);
    }

    public void update(SysResource sysResource){
    	sysResourceRepository.save(sysResource);
    }

    public void delete(int id){
    	sysResourceRepository.deleteById(id);
    }
}
