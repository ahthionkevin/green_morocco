package io.ensa.green_morocco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatiereP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    private Origine origine;

//    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "matierePS")
//    @JsonIgnore
//    private List<Produit> produits = new ArrayList<>();
//
//    public void addProduit(Produit produit) {
//        this.produits.add(produit);
//    }
//
//    public void removeProduit(Produit produit){
//        this.produits.remove(produit);
//    }

    @OneToMany(mappedBy = "matiereP")
    private List<ProduitMatiere> produitMatieres = new ArrayList<>();
}

