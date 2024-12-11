package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer>
{
	

}
