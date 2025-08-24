package com.invexo.user_service.repository;

import com.invexo.user_service.entity.LoginActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginActivityRepository extends JpaRepository<LoginActivity, Long> {

    // Get login attempts for a user
    List<LoginActivity> findByUserIdOrderByLoginTimeDesc(Long userId);

    // Get successful logins for a user
    List<LoginActivity> findByUserIdAndStatusOrderByLoginTimeDesc(Long userId, String status);

    // Get failed login attempts for a user
    List<LoginActivity> findByUserIdAndStatus(Long userId, String status);

    // Get recent login attempts within a time range (e.g., last 24 hours)
    List<LoginActivity> findByUserIdAndLoginTimeAfter(Long userId, java.time.LocalDateTime afterTime);

    List<LoginActivity> findByUserId(Long userId);

}

