package com.invexo.user_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_permission")
public class RolePermission {
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    private Permission permission;

    public Role getRole() {
        return role;
    }

    public Permission getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "role_permission{" +
                "role=" + role +
                ", permission=" + permission +
                '}';
    }
}
