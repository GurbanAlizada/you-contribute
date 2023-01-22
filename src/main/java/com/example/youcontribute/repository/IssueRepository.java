package com.example.youcontribute.repository;

import com.example.youcontribute.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue , Integer> {



}
