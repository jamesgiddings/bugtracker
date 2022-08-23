package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.application.data.entity.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer> {
    @Query("select b from Bug b " +
            "where lower(b.title) like lower(concat('%', :searchTerm, '%'))")
        List<Bug> search(@Param("searchTerm") String searchTerm);

}
