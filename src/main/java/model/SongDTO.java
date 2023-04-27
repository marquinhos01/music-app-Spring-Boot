package model;

import lombok.*;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"name", "autor"})
public class SongDTO {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String autor;
    private String lyrics;
}