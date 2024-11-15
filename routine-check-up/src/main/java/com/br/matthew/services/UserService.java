package com.br.matthew.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matthew.entities.User;
import com.br.matthew.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(Long id) {
		var userDb = repository.findById(id);
		if (userDb.isEmpty())
			throw new RuntimeException("User doesn't exist!");
		return repository.findById(id);
	}

	public User create(User user) {
		return repository.save(user);
	}

	public User Update(User user) {
		var userDb = repository.findById(user.getId());
		if (userDb.isEmpty())
			throw new RuntimeException("User doesn't exist!");
		userDb.get().setName(user.getName());
		return repository.save(userDb.get());

	}

	public Optional<User> delete(Long id) {
		var userDb = repository.findById(id);
		if (userDb.isEmpty())
			throw new RuntimeException("User doesn't exist!");
		return repository.findById(id);

	}

}
