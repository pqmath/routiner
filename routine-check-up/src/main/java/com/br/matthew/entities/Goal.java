package com.br.matthew.entities;

import java.io.Serializable;
import java.util.Objects;

import com.br.matthew.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_goal")
public class Goal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 48)
	private String title;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "status", length = 10)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Goal() {

	}

	public Goal(User user, String title, String description, Status status) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Goal other = (Goal) obj;
		return Objects.equals(id, other.id);
	}

	String addCheckIn(String content) {
		return content;
	}

	public Status getStatus() {
		return status;
	}

	public Status process() {
		return this.status;
	}

	public void done() {
		if (this.status != Status.DONE)
			this.status = Status.DONE;
	}

	public void incomplete() {
		if (this.status != Status.IN_PROCESS)
			this.status = Status.IN_PROCESS;
	}

	@Override
	public String toString() {
		return title + "\n" + description + '\n' + status;
	}
}
