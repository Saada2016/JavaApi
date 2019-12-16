package io.javabrains.springbootstarter.product;

import java.util.Date;

public class ProductDto {
	
	private Long id;

	private String title = "-";
	
	private String Field= "-";
	
	private Date createdOn;
	
	private Date updatedOn;
	
	private Long userId;
	
	private String description = "-";

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

	public String getField() {
		return Field;
	}

	public void setField(String field) {
		this.Field = field;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(Long id, String title, String field, Date createdOn, Date updatedOn, Long userId,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.Field = field;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.userId = userId;
		this.description = description;
	}

}


	