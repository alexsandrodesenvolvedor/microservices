package com.arquitetura.auth.repository;

import com.arquitetura.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String userName);

}
