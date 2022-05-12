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
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "region",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    List<Cooperative> coops = new ArrayList<>();

    public Region() {
    }

    public void addCoop(Cooperative c){
        this.coops.add(c);
    }

    public void removeCoop(Cooperative c){
        this.coops.remove(c);
    }

}

