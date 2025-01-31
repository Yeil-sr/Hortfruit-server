package com.hortfruit.authservice.authservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hortfruit.authservice.authservice.entity.Usuario;
import com.hortfruit.authservice.authservice.dto.UsuarioDTO;
import com.hortfruit.authservice.authservice.exception.UserNotFoundException;
import com.hortfruit.authservice.authservice.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Usuario usuario) {
        try {
            // Adicione a lógica para criar o usuário
            return ResponseEntity.status(201).body("Usuário criado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar usuário");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody Usuario usuario, HttpSession session) {
        Optional<Usuario> usuarioOpt = usuarioService.authenticate(usuario.getEmail(), usuario.getSenha());
        if (usuarioOpt.isPresent()) {
            // Convertendo o Usuario para UsuarioDTO
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuarioOpt.get().getId());
            usuarioDTO.setNome(usuarioOpt.get().getNome());
            usuarioDTO.setEmail(usuarioOpt.get().getEmail());
            usuarioDTO.setIsFornecedor(usuarioOpt.get().getIsFornecedor());

            session.setAttribute("user", usuarioOpt.get());
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @GetMapping("/me")
    public ResponseEntity<Object> getUser(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuário não autenticado");
        }
        
        // Convertendo o Usuario para UsuarioDTO
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setIsFornecedor(usuario.getIsFornecedor());

        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = usuarioService.getUserById(id);
        if (usuarioOpt.isEmpty()) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        
        // Convertendo o Usuario para UsuarioDTO
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioOpt.get().getId());
        usuarioDTO.setNome(usuarioOpt.get().getNome());
        usuarioDTO.setEmail(usuarioOpt.get().getEmail());
        usuarioDTO.setIsFornecedor(usuarioOpt.get().getIsFornecedor());

        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
        Optional<Usuario> usuarioOpt = Optional.empty();
        if (usuarioOpt.isEmpty()) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        
        // Convertendo o Usuario para UsuarioDTO
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioOpt.get().getId());
        usuarioDTO.setNome(usuarioOpt.get().getNome());
        usuarioDTO.setEmail(usuarioOpt.get().getEmail());
        usuarioDTO.setIsFornecedor(usuarioOpt.get().getIsFornecedor());

        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout realizado com sucesso");
    }
}
