package com.invexo.user_service.repository;

import com.invexo.user_service.entity.Profile;
import com.invexo.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
    Optional<Profile> findByUser(User user);
}
