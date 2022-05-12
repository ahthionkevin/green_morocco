package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.entity.Produit;
import io.ensa.green_morocco.entity.ProduitMatiere;
import io.ensa.green_morocco.entity.ProduitMatiereKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitMatiereRepo extends JpaRepository<ProduitMatiere, ProduitMatiereKey> {
}
