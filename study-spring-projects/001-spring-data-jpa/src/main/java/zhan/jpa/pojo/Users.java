package zhan.jpa.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_users")
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="username")
	private String username;
	private Integer userage;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="roles_id")
	private Roles roles;
	
	
	
	
	
	public Roles getRoles() {
		return roles;
	}


	public void setRoles(Roles roles) {
		this.roles = roles;
	}


	public Users() {
		super();
	}


	public Users(Integer userid, String username, Integer userage) {
		super();
		this.userid = userid;
		this.username = username;
		this.userage = userage;
	}
	
	
	public Users(Integer userid, String username, Integer userage, Roles roles) {
		super();
		this.userid = userid;
		this.username = username;
		this.userage = userage;
		this.roles = roles;
	}


	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserage() {
		return userage;
	}
	public void setUserage(Integer userage) {
		this.userage = userage;
	}
	
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", userage=" + userage + ", roles=" + roles + "]";
	}
	
	
	
}
