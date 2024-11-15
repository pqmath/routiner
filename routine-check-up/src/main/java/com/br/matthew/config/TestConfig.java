package com.br.matthew.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.matthew.entities.Activity;
import com.br.matthew.entities.Goal;
import com.br.matthew.entities.User;
import com.br.matthew.enums.Status;
import com.br.matthew.repositories.ActivityRepository;
import com.br.matthew.repositories.GoalRepository;
import com.br.matthew.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ActivityRepository activityRepo;

	@Autowired
	private GoalRepository goalRepo;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Matthew", null, null);
		User user2 = new User(null, "Jon", null, null);

		userRepo.saveAll(Arrays.asList(user1, user2));
		
		Activity act1 = new Activity(user1, "Trabalhar no aplicativo", null, null);
		Activity act2 = new Activity(user2, "Finalizar o banco de dados", null, null);
		
		activityRepo.saveAll(Arrays.asList(act1, act2));

		Goal goal1 = new Goal(user1, "Terminar o programa", "Terminar o programa esta semana", Status.IN_PROCESS);
		Goal goal2 = new Goal(user2, "Finalize o banco de dados", "Realize testes e finalize o banco de dados", Status.IN_PROCESS);

		goalRepo.saveAll(Arrays.asList(goal1, goal2));

		user1.createGoal(goal1);
		user1.createActivity(act1);
		
		user2.createGoal(goal2);
		user2.createActivity(act2);
		
		userRepo.saveAll(Arrays.asList(user1, user2));
		
	}

}
