package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
