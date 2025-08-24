package com.invexo.user_service.service;

import com.invexo.user_service.entity.LoginActivity;
import com.invexo.user_service.repository.LoginActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginActivityService {

    @Autowired
    private LoginActivityRepository loginActivityRepository;

    public List<LoginActivity> getAllActivities() {
        return loginActivityRepository.findAll();
    }

    public List<LoginActivity> getActivitiesByUserId(Long userId) {
        return loginActivityRepository.findByUserId(userId);
    }

    public LoginActivity logActivity(LoginActivity activity) {
        return loginActivityRepository.save(activity);
    }
}
