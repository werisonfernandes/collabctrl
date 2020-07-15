package br.com.werison.collabctrl.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tb_user")
@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_user", insertable = false, updatable = false)
	private int id;

	@Column(name = "nm_user", length = 100, nullable = false)
	private String name;

	@Column(name = "nm_email", length = 50, nullable = false)
	private String email;

	@Column(name = "nm_password", length = 16, nullable = false)
	private String password;

	@Column(name = "dt_creation", columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false, nullable = false)
	private LocalDateTime creationDate;

	@Column(name = "dt_update", insertable = false, columnDefinition = "timestamp")
	private LocalDateTime updateDate;

	@Column(name = "dt_exclusion", insertable = false, columnDefinition = "timestamp")
	private LocalDateTime exclusionDate;

	@Column(name = "fl_active", columnDefinition = "tinyint(1)", nullable = false)
	private Boolean active = true;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usrcreated")
	private User userCreated;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usrupdated")
	private User userUpdated;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usrdeleted")
	private User userDeleted;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Login> logins;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getExclusionDate() {
		return exclusionDate;
	}

	public void setExclusionDate(LocalDateTime exclusionDate) {
		this.exclusionDate = exclusionDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(User userCreated) {
		this.userCreated = userCreated;
	}

	public User getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(User userUpdated) {
		this.userUpdated = userUpdated;
	}

	public User getUserDeleted() {
		return userDeleted;
	}

	public void setUserDeleted(User userDeleted) {
		this.userDeleted = userDeleted;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

}