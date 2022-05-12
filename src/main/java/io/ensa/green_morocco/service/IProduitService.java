package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.ProduitRequestDTo;
import io.ensa.green_morocco.DTo.Response.ProduitResponseDTo;
import io.ensa.green_morocco.entity.MatiereP;
import io.ensa.green_morocco.entity.Produit;

import java.util.List;

public interface IProduitService {
    ProduitResponseDTo addProduit(ProduitRequestDTo produitRequestDTo, MatiereP... matierePS);
    ProduitResponseDTo getProduitById(Long produitId);
    Produit getProduit(Long produitId);
    List<ProduitResponseDTo> getProduits();
    List<ProduitResponseDTo> getProduitsByCooperative(Long idCooperative);
    List<ProduitResponseDTo> getProduitsByMatiereP(Long idMatiereP);
    ProduitResponseDTo deleteProduit(Long produitId);
    ProduitResponseDTo editProduit(Long produitId, ProduitRequestDTo produitRequestDTo);
    ProduitResponseDTo addMatierePToProduit(Long produitId, Long MatierePId);
    ProduitResponseDTo removeMatierePFromProduit(Long produitId, Long matierePId);
}
