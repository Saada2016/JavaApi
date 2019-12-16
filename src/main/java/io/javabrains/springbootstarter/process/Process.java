package io.javabrains.springbootstarter.process;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.javabrains.springbootstarter.user.User;


@Entity
@Table(name="process")
public class Process {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@Column(columnDefinition = "text")
	private String title = "-";
	
//	@Column(name="DESCRIPTION",columnDefinition= Constants.NVARCHAR_MAX)
	private String description = "-";
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private User createdBy;
	

	private Date createdOn;
	
	@ManyToOne
	private User updatedBy;
	

	private Date updatedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser(Long id) {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	
	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	
	
	