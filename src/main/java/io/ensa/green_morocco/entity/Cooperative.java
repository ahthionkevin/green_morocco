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
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String tel;

//    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    @OneToMany(mappedBy = "coop",fetch = FetchType.LAZY)
    private List<Produit> produits = new ArrayList<>();

    public void addProduit(Produit p){
        produits.add(p);
    }

    public void removeProduit(Produit p){
        produits.remove(p);
    }
}
