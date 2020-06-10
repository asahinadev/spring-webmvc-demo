package jp.mirageworld.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import jp.mirageworld.spring.entity.User;

@RepositoryDefinition(
		idClass = Integer.class,
		domainClass = User.class)
public interface UserRepository
		extends JpaRepository<User, Integer> {

}
