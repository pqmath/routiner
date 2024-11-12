package com.br.matthew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matthew.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}