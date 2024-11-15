package com.br.matthew.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.br.matthew.exceptions.InvalidField;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", length = 32)
	private String name;

	@OneToMany
	private List<Goal> goal = new ArrayList<>();

	@OneToMany
	private List<Activity> activity = new ArrayList<>();

	public User() {

	}

	public User(Long id, String name, List<Activity> activity, List<Goal> goal) {
		this.id = id;
		this.name = name;
		if (goal != null) {
			this.goal = goal;
		}
		if (activity != null) {
			this.activity = activity;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Goal> getGoal() {
		return goal;
	}

	public List<Activity> getActivity() {
		return activity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	public void createActivity(Activity activity) {
		activity.setStart();
		this.activity.add(activity);
	}

	public void endActivity(Activity act) {
		this.activity.stream().filter(a -> a.getId().equals(act.getId())).findFirst().ifPresent(a -> a.setEnd());

	}

	public void createGoal(Goal newGoal) {
		goal.add(newGoal);
	}

	public void checkIn(String content) {
		((Goal) goal).addCheckIn(content);
	}
	
	public Boolean notificate(String confirmation) throws Exception {
		if(confirmation == "Yes") {
			return true;
		}
		if (confirmation == "No"){
			return false;
		}
		throw new InvalidField("The answer must be a yes or no.");
	}
}
