package lbk.group.entity;

import javax.persistence.Column;            //OK
import javax.persistence.Entity;            //OK
import javax.persistence.FetchType;         //OK
import javax.persistence.GeneratedValue;    //OK
import javax.persistence.Id;                //OK
import javax.persistence.JoinColumn;        //OK
import javax.persistence.ManyToOne;         //OK
import javax.persistence.Table;             //OK
import javax.persistence.UniqueConstraint;  //OK

@Entity //OK
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "username" })) //OK
public class UserRole {

	@Id                                                            //OK
	@GeneratedValue                                                //OK
	@Column(name = "user_role_id", unique = true, nullable = false)//OK
	private Integer userRoleId;                                    //OK
	
	@ManyToOne(fetch = FetchType.EAGER)                            //Changed
	@JoinColumn(name = "username", nullable = false)               //OK
	private User user;                                             //OK

	@Column(name = "role", nullable = false, length = 45)          //OK
	private String role;                                           //OK

	public UserRole() {                                            //OK
		super();
	}

	public UserRole(User user, String role) {                      //OK
		super();
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoleId() {                               //OK
		return userRoleId;
	}

	public void setUserRoleId(Integer userRolId) {                 //OK
		this.userRoleId = userRolId;
	}

	public User getUser() {                                        //OK
		return user;
	}

	public void setUser(User user) {                               //OK
		this.user = user;
	}

	public String getRole() {                                      //OK
		return role;
	}

	public void setRole(String role) {                             //OK
		this.role = role;
	}

	@Override
	public String toString() {                                     //OK
		return "UserRole [userRolId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
	}
	
	

}
