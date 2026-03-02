package com.guimper.dev.Usuario.business.Converter;


import Infrastructure.entity.Endereco;
import Infrastructure.entity.Telefone;
import Infrastructure.entity.Usuario;
import com.guimper.dev.Usuario.business.DTOs.EnderecoDTO;
import com.guimper.dev.Usuario.business.DTOs.TelefoneDTO;
import com.guimper.dev.Usuario.business.DTOs.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {

        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();

    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecosDTO) {
        List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecosDTO) {
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();

    }
    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefone).toList();

    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {

        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDDD())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {

        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
                .build();

    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecosDTO) {
        List<EnderecoDTO> enderecos = new ArrayList<>();
        for (Endereco enderecoDTO : enderecosDTO) {
            enderecos.add(paraEnderecoDTO(enderecoDTO));
        }
        return enderecos;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) {
        return EnderecoDTO.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();

    }
    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();

    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO) {

        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .DDD(telefoneDTO.getDdd())
                .build();
    }
}
