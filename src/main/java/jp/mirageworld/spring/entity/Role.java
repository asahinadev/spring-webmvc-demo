package jp.mirageworld.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Table(name = "roles", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }),
})
@Entity(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(nullable = false)
	String name;

	@ManyToMany
	@JoinTable(
			name = "user_roles",
			joinColumns = {
					@JoinColumn(name = "role_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "user_id")
			})
	List<User> users;

}
