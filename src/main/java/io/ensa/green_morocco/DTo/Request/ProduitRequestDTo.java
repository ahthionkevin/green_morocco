package io.ensa.green_morocco.DTo.Request;

import io.ensa.green_morocco.entity.Cooperative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProduitRequestDTo {
    private String nom;

    private int quantite;

    private float prix;

    private Long cooperativeId;
}
