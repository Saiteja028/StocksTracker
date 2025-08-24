package com.invexo.user_service.service;

import com.invexo.user_service.entity.UserRoles;
import com.invexo.user_service.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * Get all roles assigned to a user by userId.
     */
    public List<UserRoles> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    /**
     * Assign a role to a user.
     */
    public UserRoles assignRole(UserRoles userRole) {
        return userRoleRepository.save(userRole);
    }

    /**
     * Remove all roles assigned to a user by userId.
     */
    public void removeRolesByUserId(Long userId) {
        userRoleRepository.deleteByUserId(userId);
    }

    /**
     * Remove a specific user-role mapping.
     */
    public void deleteUserRole(UserRoles userRole) {
        userRoleRepository.delete(userRole);
    }
}