package com.musicappmarcos.musicappmarcos.model;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"name", "autor"})
@Entity
public class SongDTO {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String autor;
    private String lyrics;
}