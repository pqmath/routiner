package com.br.matthew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matthew.entities.Activity;
import com.br.matthew.repositories.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;

	public List<Activity> findAll() {
		return repository.findAll();
	}

	public Optional<Activity> findById(Long id) {
		var activityDb = repository.findById(id);
		if (activityDb.isEmpty())
			throw new RuntimeException();
		return repository.findById(id);
	}

	public Activity create(Activity activity) {
		return repository.save(activity);
	}

	public Activity Update(Activity activity) {
		var activityDb = repository.findById(activity.getId());
		if (activityDb.isEmpty())
			throw new RuntimeException();
		activityDb.get().setTitle(activity.getTitle());
		return repository.save(activityDb.get());

	}

	public Optional<Activity> delete(Long id) {
		var activityDb = repository.findById(id);
		if (activityDb.isEmpty())
			throw new RuntimeException();
		return repository.findById(id);

	}

}
