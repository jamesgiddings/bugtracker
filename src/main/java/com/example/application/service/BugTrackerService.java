package com.example.application.service;

import java.util.ArrayList;
import java.util.List;

import com.example.application.data.entity.Bug;
import com.example.application.repository.BugRepository;

public class BugTrackerService {

	// Attributes

	private final BugRepository BUG_REPOSITORY;

	// Constructors

	public BugTrackerService(BugRepository bugRepository) {
		BUG_REPOSITORY = bugRepository;
	}

	// Behaviours

	public List<Bug> getAllBugs() {
		return BUG_REPOSITORY.findAll();
	}

	public BugRepository getBUG_REPOSITORY() {
		return BUG_REPOSITORY;
	}

	public List<Bug> getAllBugs(String filterText) {
		if (filterText == null || filterText.isEmpty()) {
			return BUG_REPOSITORY.findAll();
		} else {
			return BUG_REPOSITORY.search(filterText);
		}

	}

	public void delete(Bug bug1) {
		BUG_REPOSITORY.delete(bug1);
	}

	public void deleteAllBugs() {
		BUG_REPOSITORY.deleteAll();
	}

	public void saveBug(Bug bug) {
		if (bug == null) {
			System.err.println("Bug is null.");
		}

		BUG_REPOSITORY.save(bug);
	}

	public long countBugs() {
		return BUG_REPOSITORY.count();

	}

}
