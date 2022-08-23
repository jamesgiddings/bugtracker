package com.example.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.application.data.entity.Bug;
import com.example.application.repository.BugRepository;

@ExtendWith(MockitoExtension.class)
class TestBugTrackerService {

	BugTrackerService bugTrackerService; // object to be tested

	@Mock
	BugRepository bugRepository;

	@Mock
	Bug bug1, bug2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bugTrackerService = new BugTrackerService(bugRepository);
	}

	@Test
	void test_bugTrackerService_ReturnsEmptyListOfBugs_ifNoBugsInRepository() {
		List<Bug> bugs = bugTrackerService.getAllBugs();

		assertEquals(0, bugs.size());
	}

	@Test
	void test_bugTrackerService_ReturnsListOf1Bug_if1BugInRepository() {

		List<Bug> bugs = new ArrayList<>(); // Arrange
		bugs.add(bug1);

		lenient().when(bugRepository.findAll()).thenReturn(bugs);

		List<Bug> result = bugTrackerService.getAllBugs(); // Act

		assertEquals(1, result.size()); // Assert
	}
	
	@Test
	void test_bugTrackerService_ReturnsListOf1Bug_if2BugsInRepository() {

		List<Bug> bugs = new ArrayList<>(); // Arrange
		bugs.add(bug1);
		bugs.add(bug2);

		lenient().when(bugRepository.findAll()).thenReturn(bugs);

		List<Bug> result = bugTrackerService.getAllBugs(); // Act

		assertEquals(2, result.size()); // Assert
	}

	@Test
	void test_bugTrackerService_callsBugRepositoryMethodFindAll_whenGetAllBugsIsCalled() {

		List<Bug> result = bugTrackerService.getAllBugs(); // Act

		verify(bugRepository).findAll(); // Assert
	}
	
	
	@Test
	void test_bugTrackerServiceCallsBugRepositoryDeleteWithBug1PassedInWhenDeleteCalledWithBug1PassedIn() {

		bugTrackerService.delete(bug1); // Act

		verify(bugRepository).delete(bug1); // Assert
	}
	
	@Test
	void test_bugTrackerServiceCallsBugRepositoryDeleteAllWhenDeleteAllBugsCalled() {

		bugTrackerService.deleteAllBugs(); // Act

		verify(bugRepository).deleteAll(); // Assert
	}
	
	
	
	@Test
	void test_bugTrackerServiceCallsBugRepositorySaveWithBug1PassedInWhenSaveBugCalledWithBug1PassedIn() {

		bugTrackerService.saveBug(bug1); // Act

		verify(bugRepository).save(bug1); // Assert
	}
	
	@Test
	void test_bugTrackerServiceCallsBugRepositoryCountWhenBugTrackerServiceCountContactsCalled() {

		bugTrackerService.countBugs(); // Act

		verify(bugRepository).count(); // Assert
	}

}
