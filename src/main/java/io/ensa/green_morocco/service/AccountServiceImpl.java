package io.ensa.green_morocco.service;

import io.ensa.green_morocco.repository.AppRoleRepo;
import io.ensa.green_morocco.repository.AppUserRepo;
import io.ensa.green_morocco.security.AppRole;
import io.ensa.green_morocco.security.AppUser;
import io.ensa.green_morocco.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AppUserRepo userRepository;
    @Autowired
    private AppRoleRepo roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppRole saveRole(AppRole r) {
        AppRole role =roleRepository.findByRole(r.getRole());
        if (role == null ) {
            return roleRepository.save(r);
        }
        else {
            throw new IllegalStateException("le role existe déja");
        }
    }

    public void addRoleToUser(String username, Role r) {
        AppUser user=userRepository.findByUsername(username);
        AppRole role =roleRepository.findByRole(r);
        //user.addRole(role);
        user.getRoles().add(role);
        userRepository.save(user);
    }

}
