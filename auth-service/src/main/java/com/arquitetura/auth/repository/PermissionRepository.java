package com.arquitetura.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura.auth.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByDescription(String description);
}
