package org.janine.jian.securityjwtapp.repository;

import org.janine.jian.securityjwtapp.domain.SysRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysRoleRepository extends CrudRepository<SysRole, Integer>, PagingAndSortingRepository<SysRole, Integer>{

}
