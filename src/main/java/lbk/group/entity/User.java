package lbk.group.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	@Column(name = "first_name", nullable = false, length = 50)
	private String first_name;
	@Column(name = "last_name", nullable = false, length = 50)
	private String last_name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User() {
		super();
	}

	public User(String username, String password, boolean enabled, String first_name, String last_name) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public User(String username, String password, boolean enabled, String first_name, String last_name,
			Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.first_name = first_name;
		this.last_name = last_name;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
