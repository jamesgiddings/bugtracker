package com.example.application.views;

import com.example.application.data.entity.Bug;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class BugForm extends FormLayout {
	
	// Attributes
	
	private Bug bug;
	
	public Binder<Bug> binder = new BeanValidationBinder<>(Bug.class); 
	
	TextField title = new TextField("Title");
	public TextField description = new TextField("Description");
	Button testButton = new Button("Test");
	
	// Constructors
	
	public BugForm() { // TODO add clients/companies to the constructor here
		addClassName("bug-form");
		binder.bindInstanceFields(this);
		
		add(
			title,
			createButtonLayout()
		);
	}
	
	// Behaviours

	private Component createButtonLayout() {
		return testButton;
	}
	
	public void setBug(Bug bug) {
		this.bug = bug;
		binder.readBean(bug);
	}

}
