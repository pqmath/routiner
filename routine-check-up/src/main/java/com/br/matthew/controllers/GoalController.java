package com.br.matthew.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.matthew.entities.Goal;
import com.br.matthew.services.GoalService;

@RestController
@RequestMapping("/goals")
public class GoalController {

	@Autowired
	GoalService service;

	@GetMapping
	ResponseEntity<List<Goal>> findAll() {
		List<Goal> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Optional<Goal>> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	ResponseEntity<Goal> create(@RequestBody Goal goal) {
		return ResponseEntity.ok().body(service.create(goal));
	}

	@PutMapping
	ResponseEntity<Goal> update(@RequestBody Goal goal) {
		return ResponseEntity.ok().body(service.Update(goal));
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
