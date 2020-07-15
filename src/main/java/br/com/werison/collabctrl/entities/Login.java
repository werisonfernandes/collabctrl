package br.com.werison.collabctrl.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "tb_login")
@Entity
public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_login", insertable = false, updatable = false)
	private long id;

	@Column(name = "ds_token", length = 64, nullable = false)
	private String token;

	@CreationTimestamp
	@Column(name = "dt_login", columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false, nullable = false)
	private LocalDateTime loginDate;

	@UpdateTimestamp
	@Column(name = "dt_logout", insertable = false)
	private LocalDateTime logoutDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public LocalDateTime getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(LocalDateTime logoutDate) {
		this.logoutDate = logoutDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
