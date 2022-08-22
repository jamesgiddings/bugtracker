package com.example.application.views;

import java.util.List;

import com.example.application.data.entity.User;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class UserForm extends FormLayout {
	
	// Attributes
	
	User user;
	
	Binder<User> binder = new BeanValidationBinder<>(User.class);

	public TextField firstName = new TextField("");
	
	// Behaviours
	
	public UserForm() {
		addClassName("user-form");
		binder.bindInstanceFields(this);
		
		add(firstName);
	}
	
	public void setUser(User user) {
		this.user = user;
		binder.readBean(user);
	}

}
