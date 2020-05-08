package org.janine.jian.securityjwtapp.repository;

import org.janine.jian.securityjwtapp.domain.SysResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysResourceRepository extends CrudRepository<SysResource, Integer>, PagingAndSortingRepository<SysResource, Integer>{

}
