package io.ensa.green_morocco.DTo.Response;

import io.ensa.green_morocco.entity.Cooperative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProduitResponseDTo {
    private Long id;

    private String nom;

    private int quantite;

    private float prix;

    private Long cooperativeId;

    List<Long> matierePids;
}
