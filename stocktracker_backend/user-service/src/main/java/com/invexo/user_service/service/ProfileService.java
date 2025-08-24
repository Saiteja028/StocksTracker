package com.invexo.user_service.service;

import com.invexo.user_service.entity.Profile;
import com.invexo.user_service.entity.User;
import com.invexo.user_service.repository.ProfileRepository;
import com.invexo.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    // Get all profiles
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    // Get profile by ID
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    // Create a new profile
    public Profile createProfile(Profile profile) {
        if (profile.getUser() != null) {
            Long userId = profile.getUser().getId();
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            profile.setUser(user);
        }
        return profileRepository.save(profile);
    }

    // Update an existing profile
    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        existingProfile.setFirstName(profileDetails.getFirstName());
        existingProfile.setLastName(profileDetails.getLastName());
        existingProfile.setDob(profileDetails.getDob());
        existingProfile.setGender(profileDetails.getGender());
        existingProfile.setAddress(profileDetails.getAddress());
        existingProfile.setAvatarUrl(profileDetails.getAvatarUrl());
        // updated_at can be handled automatically with @PreUpdate or manually
        existingProfile.setUpdatedAt(java.time.LocalDateTime.now());


        return profileRepository.save(existingProfile);
    }

    // Delete a profile
    public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        profileRepository.delete(profile);
    }

    // Get profile by user ID
    public Optional<Profile> getProfileByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return profileRepository.findByUser(user);
    }
}
