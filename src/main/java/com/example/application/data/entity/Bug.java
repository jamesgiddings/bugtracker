package com.example.application.data.entity;

import javax.validation.constraints.NotEmpty;

public class Bug extends AbstractEntity {
	
	//Attributes
	@NotEmpty
	private String title = "";
	
	private String description = "";
	
	//Behaviours
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



}
