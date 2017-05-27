package eu.davidem.wallet.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity managed by Hiberante to store the data
 * 
 * @author Davide Martorana
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	private String username;
	private String password;

	public User(){
		
	}
	
	public User(Role role, String username, String password) {
		this.role = role.name();
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role.name();
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

	public String toString() {
		return String.format("User[id= '%s', username= '%s', password=<PROTECTED>, role=%s]", this.id, this.username,
				this.role);
	}

}
