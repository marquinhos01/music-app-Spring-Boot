package com.musicappmarcos.musicappmarcos.services;

import com.musicappmarcos.musicappmarcos.model.UserDTO;
import com.musicappmarcos.musicappmarcos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    public Optional<UserDTO> obtenerUsuarioPorDni(String id) {
        return Optional.ofNullable(userRepository.findByDni(id));
    }

    public List<UserDTO> obtenerUsuarios() {
        return userRepository.findAll();
    }

    public List<UserDTO> obtenerUsuariosMenoresDe(Integer edad) {
        return userRepository.findByAgeLessThan(edad);
    }

    public List<UserDTO> obtenerUsuariosPorNombre(String nombre) {
        return userRepository.findByName(nombre);
    }

    public UserDTO guardarUsuario(UserDTO userDTO) {
        return userRepository.save(userDTO);
    }


    public void  borrarUsuarioConDNI(String dni) {
         userRepository.deleteByDni(dni);
    }
}
