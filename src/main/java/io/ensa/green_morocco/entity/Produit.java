package io.ensa.green_morocco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int quantite;

    private float prix;

    @ManyToOne
    private Cooperative coop;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(
//            name="produit_matiere",
//            joinColumns = @JoinColumn(name = "produit_id"),
//            inverseJoinColumns = @JoinColumn(name = "matiere_id")
//    )
//    private List<MatiereP> matierePS = new ArrayList<>();

    @OneToMany(mappedBy = "produit")
    private List<ProduitMatiere> produitMatieres = new ArrayList<>();

    public void addMatiere(MatiereP m){
        this.produitMatieres.add(new ProduitMatiere(new ProduitMatiereKey(id,m.getId()),this,m));
    }
//
//    public void removeMatiere(MatiereP m){
//        this.matierePS.remove(m);
//    }
}

