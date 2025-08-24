package com.invexo.user_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    public User getUser() {
        return user;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "user_roles{" +
                "user=" + user +
                ", role=" + role +
                ", assignedAt=" + assignedAt +
                '}';
    }
}
