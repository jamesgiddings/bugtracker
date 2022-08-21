package com.example.application.views;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.application.data.entity.Bug;

class BugFormTest {

	@Test
	void test_checkFormFieldsPopulateCorrectly() {
		BugForm bugForm = new BugForm(); // (companies, statuses); // Arrange
		Bug testBug = new Bug();
		
		testBug.setTitle("test bug");
		testBug.setDescription("A tricky little bug.");
		
		bugForm.setBug(testBug); // Act
    	
    	assertEquals("test bug", bugForm.title.getValue()); // Assert
    	assertEquals("A tricky little bug.", bugForm.description.getValue()); // Assert
	}

}
