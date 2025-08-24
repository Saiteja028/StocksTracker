package com.invexo.user_service.controller;

import com.invexo.user_service.entity.Profile;
import com.invexo.user_service.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        return ResponseEntity.ok(profileService.updateProfile(id, profileDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
