package com.br.matthew.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_activity")
public class Activity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "activity_title", length = 48)
	private String title;

	@Column(name = "activity_start")
	private LocalTime start;
	
	@Column(name = "activity_end")
	private LocalTime end;

	@Column(name = "time_spent")
	private Duration timeSpent;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Activity() {

	}

	public Activity(User user, String title, LocalTime start, LocalTime end) {
		this.user = user;
		this.title = title;
		this.start = start;
		this.end = end;

		if (start != null && end != null) {
			this.timeSpent = Duration.between(start, end);
		} else {
			this.timeSpent = Duration.ZERO;
		}
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

	public LocalTime getStart() {
		return start;
	}

	public void setStart() {
		this.start = LocalTime.now();
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd() {
		this.end = LocalTime.now();
	}

	public Duration getTimeSpent() {
		return timeSpent;
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
		Activity other = (Activity) obj;
		return Objects.equals(id, other.id);
	}

	public LocalTime startActivity() {
		return this.start;
	}

	public LocalTime endActivity() {
		return this.end;
	}

//	public Duration hoursSpent() {
//		if (start != null && end != null) {
//			return Duration.between(start, end);
//		} else {
//			throw new RuntimeException("Start or end time cannot be empty");
//		}
//	}

	@Override
	public String toString() {
		return title + ".\nInicio = " + start + ".\nTérmino = " + end + "\nTempo gasto: " + timeSpent;
	}

}
