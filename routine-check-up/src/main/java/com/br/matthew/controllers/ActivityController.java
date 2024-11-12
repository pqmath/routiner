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

import com.br.matthew.entities.Activity;
import com.br.matthew.services.ActivityService;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

	@Autowired
	ActivityService service;

	@GetMapping
	ResponseEntity<List<Activity>> findAll() {
		List<Activity> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Optional<Activity>> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	ResponseEntity<Activity> create(@RequestBody Activity activity) {
		return ResponseEntity.ok().body(service.create(activity));
	}

	@PutMapping
	ResponseEntity<Activity> update(@RequestBody Activity activity) {
		return ResponseEntity.ok().body(service.Update(activity));
	}

	@DeleteMapping(value = "/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
