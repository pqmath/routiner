package com.br.matthew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matthew.entities.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>{

}
