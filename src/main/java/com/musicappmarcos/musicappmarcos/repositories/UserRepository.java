package com.musicappmarcos.musicappmarcos.repositories;

import com.musicappmarcos.musicappmarcos.model.UserDTO;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {

    public UserDTO findByDni(String id);
    public List<UserDTO> findAll();
    public List<UserDTO> findByAgeLessThan(Integer age);
    public List<UserDTO> findByName(String name);


}
