package uo.sdi.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An implementation of the DTO pattern to get info about users 
 * 
 * @author Fernando Freije
 */
@XmlRootElement(name = "userInfo")
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String login;
	private String email;
	private int completedTasks;
	private int lateCompletedTasks;
	private int plannedTasks;
	private int unplannedTasks;
	
	@XmlElement
	public Long getId() {
		return id;
	}

	public UserInfo setId(Long id) {
		this.id = id;
		return this;
	}
	
	@XmlElement
	public String getLogin() {
		return login;
	}

	public UserInfo setLogin(String login) {
		this.login = login;
		return this;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}

	public UserInfo setEmail(String email) {
		this.email = email;
		return this;
	}
	
	@XmlElement
	public int getCompletedTasks() {
		return completedTasks;
	}

	public UserInfo setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
		return this;
	}
	
	@XmlElement
	public int getLateCompletedTasks() {
		return lateCompletedTasks;
	}

	public UserInfo setLateCompletedTasks(int lateCompletedTasks) {
		this.lateCompletedTasks = lateCompletedTasks;
		return this;
	}
	
	@XmlElement
	public int getPlannedTasks() {
		return plannedTasks;
	}

	public UserInfo setPlannedTasks(int plannedTasks) {
		this.plannedTasks = plannedTasks;
		return this;
	}
	
	@XmlElement
	public int getUnplannedTasks() {
		return unplannedTasks;
	}

	public UserInfo setUnplannedTasks(int unplannedTasks) {
		this.unplannedTasks = unplannedTasks;
		return this;
	}
}
