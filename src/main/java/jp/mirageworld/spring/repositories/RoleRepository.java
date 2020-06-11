package jp.mirageworld.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import jp.mirageworld.spring.entity.Role;

@RepositoryDefinition(
		idClass = Integer.class,
		domainClass = Role.class)
public interface RoleRepository
		extends JpaRepository<Role, Integer> {

}
