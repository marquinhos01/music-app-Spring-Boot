package com.musicappmarcos.musicappmarcos.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class UserDTO {
    private Integer id;
    @NonNull
    private String dni;
    @NonNull
    private String name;
    @ToString.Exclude
    @NonNull
    private String password;
    private Date age;
}
