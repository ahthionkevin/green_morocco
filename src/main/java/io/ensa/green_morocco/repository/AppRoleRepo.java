package io.ensa.green_morocco.repository;

import io.ensa.green_morocco.security.AppRole;
import io.ensa.green_morocco.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    public AppRole findByRole(Role r);
}
