package com.lucasferraz.medicalconsult.usuario.services;

import com.lucasferraz.medicalconsult.usuario.domain.Usuario;
import com.lucasferraz.medicalconsult.usuario.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado: ", id));
    }
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = buscarUsuario(id);

        if (usuarioAtualizado.getNomeUsuario() != null) {
            usuarioExistente.setNomeUsuario(usuarioAtualizado.getNomeUsuario());
        }
        if (usuarioAtualizado.getEmail() != null) {
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        }
        if (usuarioAtualizado.getTelefone() != null) {
            usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
        }
        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuario(id);
        usuarioRepository.delete(usuario);
    }
}
