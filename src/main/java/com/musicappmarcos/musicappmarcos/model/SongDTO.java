package com.musicappmarcos.musicappmarcos.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"name", "autor"})
@Entity
@Table(name = "Cancion")
public class SongDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String autor;
    private String lyrics;
}