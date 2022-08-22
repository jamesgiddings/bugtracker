package com.example.application.views;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.application.data.entity.Bug;
import com.example.application.data.entity.Client;

class UserFormTest {

	@Test
	void test_checkFormFieldsPopulateCorrectly() {
		UserForm userForm = new UserForm(); // (companies, statuses); // Arrange
		Client client1 = new Client();
		
		client1.setFirstName("Dan");
		
		userForm.setUser(client1); // Act
    	
    	assertEquals("Dan", userForm.firstName.getValue()); // Assert
	}

}
