package com.hortfruit.authservice.authservice.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hortfruit.authservice.authservice.dto.UsuarioDTO;
import com.hortfruit.authservice.authservice.entity.Usuario;
import com.hortfruit.authservice.authservice.exception.UserNotFoundException;
import com.hortfruit.authservice.authservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario createUser(String nome, String email, String senha, Boolean isFornecedor) {
        String hashedPassword = passwordEncoder.encode(senha);
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(hashedPassword);
        usuario.setIsFornecedor(isFornecedor);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }


    public UsuarioDTO getUserByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado para o email: " + email));
        return mapToDTO(usuario);
    }

        public Optional<Usuario> authenticate(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(senha, usuario.getSenha())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    public void iniciarRecuperacaoSenha(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado para o email: " + email));

        String token = generateResetToken();
        usuario.setResetToken(token);
        usuario.setResetTokenExpiry(LocalDateTime.now().plusHours(1));
        usuarioRepository.save(usuario);
    }

    public void redefinirSenha(String token, String novaSenha) {
        Usuario usuario = usuarioRepository.findByResetTokenAndResetTokenExpiryAfter(token, LocalDateTime.now())
                .orElseThrow(() -> new UserNotFoundException("Token inválido ou expirado"));

        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuario.setResetToken(null);
        usuario.setResetTokenExpiry(null);
        usuarioRepository.save(usuario);
    }

    private String generateResetToken() {
        return java.util.UUID.randomUUID().toString();
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setIsFornecedor(usuario.getIsFornecedor());
        return dto;
    }

   
}
