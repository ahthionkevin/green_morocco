package io.ensa.green_morocco.DTo.Response;

import io.ensa.green_morocco.entity.Origine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatierePResponseDTo {

    private Long id;

    private String nom;

    private Long origineId;

}
