package org.janine.jian.securityjwtapp.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.janine.jian.securityjwtapp.domain.SysPermission;
import org.janine.jian.securityjwtapp.domain.SysResource;
import org.janine.jian.securityjwtapp.domain.SysUser;
import org.janine.jian.securityjwtapp.domain.SysUserRole;
import org.janine.jian.securityjwtapp.repository.SysPermissionRepository;
import org.janine.jian.securityjwtapp.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService{
	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private SysPermissionRepository sysPermissionRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserRepository.findByUsername(username);//find user information
		
		if(null == sysUser)throw new UsernameNotFoundException("user【"+username+"】 is not find");
		
		List<Integer> roleIds = sysUser.getRoles().stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
		Set<SysPermission> sysPermissions = new HashSet<>();
		for (int i = 0; i < roleIds.size(); i++) {
			sysPermissions.addAll(sysPermissionRepository.findAllByRoleId(roleIds.get(i)));
		}
		
		
		return new org.springframework.security.core.userdetails.User(sysUser.getUsername(),"{bcrypt}"+sysUser.getPassword(),sysPermissions.stream()
                .map(sysPermission -> new CustomGrantedAuthority(sysPermission.getResource()))
                .collect(Collectors.toList()));
	}
	
	class CustomGrantedAuthority implements GrantedAuthority {
		private static final long serialVersionUID = 1L;
		private SysResource authority;
        public CustomGrantedAuthority(){}
        public CustomGrantedAuthority(SysResource authority){
            this.authority = authority;
        }
        @Override
        public String getAuthority() {
            return authority.getResourceOperation();
        }
    }

	public SysUserRepository getSysUserRepository() {
		return sysUserRepository;
	}
	public void setSysUserRepository(SysUserRepository sysUserRepository) {
		this.sysUserRepository = sysUserRepository;
	}
	public SysPermissionRepository getSysPermissionRepository() {
		return sysPermissionRepository;
	}
	public void setSysPermissionRepository(SysPermissionRepository sysPermissionRepository) {
		this.sysPermissionRepository = sysPermissionRepository;
	}
	
}
