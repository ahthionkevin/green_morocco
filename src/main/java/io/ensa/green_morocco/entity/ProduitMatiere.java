package io.ensa.green_morocco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ProduitMatiere {

    @EmbeddedId
    private ProduitMatiereKey id;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    @JoinColumn()
    private MatiereP matiereP;
}
