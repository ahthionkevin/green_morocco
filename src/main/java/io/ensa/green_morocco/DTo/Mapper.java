package io.ensa.green_morocco.DTo;

import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.DTo.Response.ProduitResponseDTo;
import io.ensa.green_morocco.entity.Cooperative;
import io.ensa.green_morocco.entity.MatiereP;
import io.ensa.green_morocco.entity.Produit;
import io.ensa.green_morocco.entity.ProduitMatiere;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static CooperativeResponseDTo cooperativeToCooperativeResponseDTo(Cooperative cooperative){
        CooperativeResponseDTo cooperativeResponseDTo = new CooperativeResponseDTo();
        cooperativeResponseDTo.setId(cooperative.getId());
        cooperativeResponseDTo.setNom(cooperative.getNom());
        cooperativeResponseDTo.setRegionId(cooperative.getRegion().getId());
        cooperativeResponseDTo.setTel(cooperative.getTel());

        if(cooperative.getProduits().isEmpty() || cooperative.getProduits()==null){
            cooperativeResponseDTo.setProduitId(null);
            return cooperativeResponseDTo;
        }
        List<Long> produitIds = new ArrayList<>();

        for(Produit p : cooperative.getProduits()){
            produitIds.add(p.getId());
        }
        cooperativeResponseDTo.setProduitId(produitIds);
        return cooperativeResponseDTo;
    }

    public static List<CooperativeResponseDTo> cooperativeToCooperativeResponseDTo(List<Cooperative> cooperatives){
        List<CooperativeResponseDTo> cooperativeResponseDTos = new ArrayList<>();

        for(Cooperative cooperative :  cooperatives){
            cooperativeResponseDTos.add(cooperativeToCooperativeResponseDTo(cooperative));
        }
        return cooperativeResponseDTos;
    }

    public static MatierePResponseDTo matiereToMatierePResponseDTo(MatiereP matiereP){
        MatierePResponseDTo matierePResponseDTo = new MatierePResponseDTo();
        matierePResponseDTo.setId(matiereP.getId());
        matierePResponseDTo.setNom(matiereP.getNom());
        matierePResponseDTo.setOrigineId(matiereP.getOrigine().getId());
        return matierePResponseDTo;
    }

    public static List<MatierePResponseDTo> matiereToMatierePResponseDTo(List<MatiereP> matierePs){
        List<MatierePResponseDTo> matierePResponseDTos = new ArrayList<>();

        for(MatiereP matiereP : matierePs){
            matierePResponseDTos.add(matiereToMatierePResponseDTo(matiereP));
        }
        return matierePResponseDTos;
    }

    public static ProduitResponseDTo produitToProduitResponseDTo(Produit produit){
        ProduitResponseDTo produitResponseDTo = new ProduitResponseDTo();
        produitResponseDTo.setId(produit.getId());
        produitResponseDTo.setNom(produit.getNom());
        produitResponseDTo.setPrix(produit.getPrix());
        produitResponseDTo.setQuantite(produit.getQuantite());
        produitResponseDTo.setCooperativeId(produit.getCoop().getId());
        List<Long> matierePIds = new ArrayList<>();

//        for(MatiereP matiereP : produit.getMatierePS()){
//            matierePIds.add(matiereP.getId());
//        }
        for(ProduitMatiere produitMatiere : produit.getProduitMatieres()){
            matierePIds.add(produitMatiere.getMatiereP().getId());
        }
        produitResponseDTo.setMatierePids(matierePIds);

        return produitResponseDTo;
    }

    public static List<ProduitResponseDTo> produitToProduitResponseDTo(List<Produit> produits){
        List<ProduitResponseDTo> produitResponseDTos = new ArrayList<>();

        for(Produit produit : produits){
            produitResponseDTos.add(produitToProduitResponseDTo(produit));
        }
        return produitResponseDTos;
    }
}
