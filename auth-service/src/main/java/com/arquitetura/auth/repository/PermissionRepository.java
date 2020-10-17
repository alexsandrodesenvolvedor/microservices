package com.arquitetura.auth.repository;

import com.arquitetura.auth.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByDescription(String description);

}
