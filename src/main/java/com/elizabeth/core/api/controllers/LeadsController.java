package com.elizabeth.core.api.controllers;

import java.util.List;

import com.elizabeth.core.domain.Lead;
import com.elizabeth.core.domain.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/leads")
@RestController
public class LeadsController {
	
	@Autowired
	private LeadRepository repository;

	@GetMapping
	public ResponseEntity<List<Lead>> leads() {
		List<Lead> leads = repository.findAll();
		return ResponseEntity.ok(leads);
	}

}
