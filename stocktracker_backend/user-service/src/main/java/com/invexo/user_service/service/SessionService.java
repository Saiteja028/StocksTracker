package com.invexo.user_service.service;

import com.invexo.user_service.entity.Session;
import com.invexo.user_service.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public Optional<Session> getSessionByRefreshToken(String refreshToken) {
        return sessionRepository.findByRefreshToken(refreshToken);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
