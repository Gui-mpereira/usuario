package com.guimper.dev.Usuario.business;


import Infrastructure.entity.Usuario;
import Infrastructure.repository.UsuarioRepository;
import com.guimper.dev.Usuario.business.Converter.UsuarioConverter;
import com.guimper.dev.Usuario.business.DTOs.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salva(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        return null;
    }
}
