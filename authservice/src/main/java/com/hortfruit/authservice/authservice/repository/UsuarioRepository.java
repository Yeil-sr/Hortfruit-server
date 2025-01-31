package com.hortfruit.authservice.authservice.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hortfruit.authservice.authservice.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByResetTokenAndResetTokenExpiryAfter(String resetToken, LocalDateTime expiryDate);
}
