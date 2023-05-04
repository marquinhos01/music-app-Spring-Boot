package com.musicappmarcos.musicappmarcos.controller;

import com.musicappmarcos.musicappmarcos.model.Errors;
import com.musicappmarcos.musicappmarcos.model.UserDTO;
import com.musicappmarcos.musicappmarcos.services.UserService;
import org.apache.catalina.User;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(path = "/example")
    public ResponseEntity<UserDTO> getCommonMessage() {
        UserDTO userDTO = new UserDTO("123", "Marcos", "Fvi37bxjk", 1);
        return ResponseEntity.ok(userDTO);
    }

    //Enviar por parametros
    @PostMapping(path = "/create", params = {"dni", "name", "password", "age"})
    public ResponseEntity<?> createUserDTO(@RequestParam String dni, @RequestParam String name, @RequestParam String password, @RequestParam Integer age) {
        Map<Object, Object> mensaje = new HashMap<>();
        UserDTO userDTO = new UserDTO(dni, name, password, age);
        try {
            userService.guardarUsuario(userDTO);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            mensaje.put("ERROR ", "Ya existe una persona con ese dni");
            return ResponseEntity.badRequest().body(mensaje);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUserDTO2(@RequestBody UserDTO userDTO) {
        Map<Object, Object> mensaje = new HashMap<>();
        try {
            UserDTO user = userService.guardarUsuario(userDTO);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            mensaje.put("ERROR ", "Ya existe una persona con ese DNI");
            return ResponseEntity.badRequest().body(mensaje);
        }
    }

    @GetMapping(path = "/{dni}")
    public ResponseEntity<?> getUserDTOByDNI(@PathVariable String dni) {
        Optional<UserDTO> userDTO = userService.obtenerUsuarioPorDni(dni);
        if (userDTO.isPresent())
            return ResponseEntity.ok(userDTO);
        else {
            Map<Object, Object> mensaje = new HashMap<>();
            mensaje.put("Mensaje: ", "No se encontro un usuario con dni " + dni);
            return ResponseEntity.badRequest().body(mensaje);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllUserDTO() {
        Map<Object, Object> mensaje = new HashMap<>();
        List<UserDTO> usuarios = userService.obtenerUsuarios();
        if (usuarios.size() == 0) {
            mensaje.put("No existen usuarios en la base de datos", usuarios);
            return ResponseEntity.ok(mensaje);
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(path = "/less/{age}")
    public ResponseEntity<?> usersAgeLessThan(@PathVariable Integer age) {
        Map<Object, Object> mensaje = new HashMap<>();
        List<UserDTO> usuarios = userService.obtenerUsuariosMenoresDe(age);
        if (usuarios.size() == 0) {
            mensaje.put("No existen usuarios menores a: ", age);
            return ResponseEntity.ok(mensaje);
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<?> usersNameEquals(@PathVariable String name) {
        Map<Object, Object> mensaje = new HashMap<>();
        List<UserDTO> usuarios = userService.obtenerUsuariosPorNombre(name);
        if (usuarios.size() == 0) {
            mensaje.put("No existen usuarios con nombre: ", name);
            return ResponseEntity.ok(mensaje);
        }
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping(path = "/dni/{dni}")
    @Transactional
    public ResponseEntity<?> deleteByDni(@PathVariable String dni) {
        Map<Object, Object> mensaje = new HashMap<>();
        try {
            userService.borrarUsuarioConDNI(dni);
            return ResponseEntity.ok("Borrado");

        } catch (Exception e) {
            mensaje.put("No existe el usuario para borrarlo; DNI: ", dni);
            return ResponseEntity.ok(mensaje);
        }


    }
}
