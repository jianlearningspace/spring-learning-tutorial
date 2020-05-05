package org.shadow.simplecurd.repository;

import java.util.List;
import java.util.Map;

import org.shadow.simplecurd.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,PagingAndSortingRepository<User, Long>{

	@Query(value = "select u.user_id ,a.address_id ,u.username ,a.address_name from user u,address a where u.address_id = a.address_id", nativeQuery=true)
	List<Map<String, Object>> findUserMapBySQL();
}
