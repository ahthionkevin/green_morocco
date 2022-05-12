package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region,Long> {
}
