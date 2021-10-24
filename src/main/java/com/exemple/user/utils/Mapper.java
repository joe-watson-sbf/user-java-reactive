package com.exemple.user.utils;

import com.exemple.user.dto.UsuarioDTO;
import com.exemple.user.entity.Usuario;
import org.springframework.beans.BeanUtils;

public class Mapper {

    public static UsuarioDTO entityToDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO;
    }

    public static Usuario dtoToEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return usuario;
    }
}
