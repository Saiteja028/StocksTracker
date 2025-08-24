package com.invexo.user_service.controller;

import com.invexo.user_service.entity.UserRoles;
import com.invexo.user_service.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/user/{userId}")
    public List<UserRoles> getRolesByUserId(@PathVariable Long userId) {
        return userRoleService.getRolesByUserId(userId);
    }

    @PostMapping
    public UserRoles assignRoleToUser(@RequestBody UserRoles userRole) {
        return userRoleService.assignRole(userRole);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> removeRolesByUserId(@PathVariable Long userId) {
        userRoleService.removeRolesByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
