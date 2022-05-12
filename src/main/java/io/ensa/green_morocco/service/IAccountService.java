package io.ensa.green_morocco.service;

import io.ensa.green_morocco.security.AppRole;
import io.ensa.green_morocco.security.AppUser;
import io.ensa.green_morocco.security.Role;

public interface IAccountService {
    public AppUser findUserByUsername(String username);
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole r);
    public void addRoleToUser(String username, Role r);
}

