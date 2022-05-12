package io.ensa.green_morocco.security;

public enum Role {

    ADMIN("ADMIN"),
    COOPERATIVE("COOPERATIVE"),
    UTILISATEUR("UTILISATEUR");

    private String role = "";

    Role(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString(){
        return role;
    }
}