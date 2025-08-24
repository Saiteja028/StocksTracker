package com.invexo.user_service.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_activity")
public class LoginActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime loginTime;
    private String ipAddress;
    private String deviceInfo;
    private String status;

    // 🔹 Many-to-One with User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "login_activity{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", ipAddress='" + ipAddress + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
