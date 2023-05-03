package com.musicappmarcos.musicappmarcos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"dni"})
@Entity
@Table(name = "usuarios")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String dni;
    @NonNull
    private String name;
    @ToString.Exclude
    @NonNull
    private String password;
    @NonNull
    private Integer age;
}
