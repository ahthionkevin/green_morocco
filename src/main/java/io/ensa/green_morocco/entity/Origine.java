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
public class Origine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "origine",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<MatiereP> matierePS = new ArrayList<>();

    public void addMatiereP(MatiereP c){
        this.matierePS.add(c);
    }

    public void removeMatiereP(MatiereP c){
        this.matierePS.remove(c);
    }
}

