package com.invexo.user_service.repository;

import com.invexo.user_service.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    // Fetch session by refresh token
    Optional<Session> findByRefreshToken(String refreshToken);

    // Fetch all sessions for a specific user
    List<Session> findByUserId(Long userId);

    // Delete session by refresh token (logout)
    void deleteByRefreshToken(String refreshToken);

    // Delete expired sessions (cleanup job)
    void deleteByExpiresAtBefore(java.time.LocalDateTime currentTime);

    // Check if a user has an active session
    boolean existsByUserIdAndExpiresAtAfter(Long userId, java.time.LocalDateTime currentTime);

}
