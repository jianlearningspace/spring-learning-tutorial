package org.janine.jian.securityjwtapp.repository;

import java.util.List;

import org.janine.jian.securityjwtapp.domain.SysPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysPermissionRepository extends CrudRepository<SysPermission, Integer>, PagingAndSortingRepository<SysPermission, Integer>{

	public List<SysPermission> findAllByRoleId(int id);
}
