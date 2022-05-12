package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
