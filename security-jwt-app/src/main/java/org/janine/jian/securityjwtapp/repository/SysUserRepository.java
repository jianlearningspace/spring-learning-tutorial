package org.janine.jian.securityjwtapp.repository;

import org.janine.jian.securityjwtapp.domain.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysUserRepository extends CrudRepository<SysUser, Integer>, PagingAndSortingRepository<SysUser, Integer>{

	public SysUser findByUsername(String username);
}
