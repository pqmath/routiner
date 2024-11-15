package com.br.matthew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matthew.entities.Goal;
import com.br.matthew.repositories.GoalRepository;

@Service
public class GoalService {

	@Autowired
	private GoalRepository repository;

	public List<Goal> findAll() {
		return repository.findAll();
	}

	public Optional<Goal> findById(Long id) {
		var goalDb = repository.findById(id);
		if (goalDb.isEmpty())
			throw new RuntimeException();
		return repository.findById(id);
	}

	public Goal create(Goal goal) {
		return repository.save(goal);
	}

	public Goal Update(Goal goal) {
		var goalDb = repository.findById(goal.getId());
		if (goalDb.isEmpty())
			throw new RuntimeException();
		goalDb.get().setTitle(goal.getTitle());
		goalDb.get().setDescription(goal.getDescription());
		return repository.save(goalDb.get());

	}

	public Optional<Goal> delete(Long id) {
		var goalDb = repository.findById(id);
		if (goalDb.isEmpty())
			throw new RuntimeException();
		return repository.findById(id);

	}

}
