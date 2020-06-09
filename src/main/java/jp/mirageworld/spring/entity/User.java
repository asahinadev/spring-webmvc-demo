package jp.mirageworld.spring.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }),
})
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(nullable = false)
	String username;

	@Column(nullable = false)
	String email;

	@Column(nullable = false)
	String password;

	@CreatedDate
	@Column(nullable = false)
	LocalDateTime created;

	@LastModifiedDate
	@Column(nullable = false)
	LocalDateTime updated;

	@ManyToMany(mappedBy = "users")
	List<Role> roles;

}
