package com.example.application.data.entity;

import javax.validation.constraints.NotEmpty;

public class User extends AbstractEntity {
	
	@NotEmpty
    private String firstName = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
