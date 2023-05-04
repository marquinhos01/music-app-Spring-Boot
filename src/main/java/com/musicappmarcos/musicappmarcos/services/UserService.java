package com.musicappmarcos.musicappmarcos.services;

import com.musicappmarcos.musicappmarcos.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public Optional<UserDTO> obtenerUsuarioPorDni(String id);
    public List<UserDTO> obtenerUsuarios();

    public List<UserDTO> obtenerUsuariosMenoresDe(Integer edad);

    public List<UserDTO> obtenerUsuariosPorNombre(String nombre);

    public UserDTO guardarUsuario(UserDTO userDTO);

    public void borrarUsuarioConDNI(String dni);

}
