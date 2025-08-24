package com.invexo.user_service.repository;

import com.invexo.user_service.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {

    List<UserRoles> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}

