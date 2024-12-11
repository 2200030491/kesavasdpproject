package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Scheme;

public interface SchemeRepository extends JpaRepository<Scheme, Integer>
{
	

}
