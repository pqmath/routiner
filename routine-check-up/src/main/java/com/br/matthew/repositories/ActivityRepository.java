package com.br.matthew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matthew.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
