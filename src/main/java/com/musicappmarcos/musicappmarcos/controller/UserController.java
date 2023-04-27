package com.musicappmarcos.musicappmarcos.controller;

import com.musicappmarcos.musicappmarcos.model.Errors;
import com.musicappmarcos.musicappmarcos.model.UserDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping(path = "/example")
    public ResponseEntity<UserDTO> getCommonMessage() {
        UserDTO userDTO = new UserDTO("123", "Marcos", "Fvi37bxjk");
        return ResponseEntity.ok(userDTO);
    }

    //Enviar por parametros
    @PostMapping(path = "/create", params = {"dni", "name", "password"})
    public ResponseEntity<UserDTO> createUserDTO(@RequestParam String dni, @RequestParam String name, @RequestParam String password) {
        UserDTO userDTO = new UserDTO(dni, name, password);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDTO> createUserDTO2(@RequestBody UserDTO userDTO) {
            return ResponseEntity.ok(userDTO);
    }
    @GetMapping(path = "/{dni}")
    public ResponseEntity<UserDTO> getUserDTOByDNI(@PathVariable String dni){
        UserDTO userDTO1 = new UserDTO("45307940","Marcos", "pasfjiu8");
        UserDTO userDTO2 = new UserDTO("24156356","Pepe", "Casojgui");
        return ResponseEntity.ok(userDTO1);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<UserDTO>> getAllUserDTO(){
        List<UserDTO> list = new ArrayList<UserDTO>();
        UserDTO userDTO1 = new UserDTO("45307940","Marcos", "pasfjiu8");
        UserDTO userDTO2 = new UserDTO("24156356","Pepe", "Casojgui");
        list.add(userDTO1);
        list.add(userDTO2);
        return ResponseEntity.ok(list);
    }
}
