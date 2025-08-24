package com.invexo.user_service.repository;


import com.invexo.user_service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    // Find by name (useful for assigning permissions)
    Optional<Permission> findByName(String name);

    // Check if a permission exists by name
    boolean existsByName(String name);
}