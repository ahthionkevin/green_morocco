package io.ensa.green_morocco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class ProduitMatiereKey implements Serializable {
    @Column(name = "produit_id")
    private Long idProduit;

    @Column(name = "matiere_id")
    private Long idMatiere;
}
