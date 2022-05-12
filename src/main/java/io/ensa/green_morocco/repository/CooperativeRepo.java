package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.entity.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperativeRepo extends JpaRepository<Cooperative,Long> {
    Cooperative findCooperativeByNom(String nom);
}
