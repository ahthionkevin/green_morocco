package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Mapper;
import io.ensa.green_morocco.DTo.Request.ProduitRequestDTo;
import io.ensa.green_morocco.DTo.Response.ProduitResponseDTo;
import io.ensa.green_morocco.entity.Cooperative;
import io.ensa.green_morocco.entity.MatiereP;
import io.ensa.green_morocco.entity.Produit;
import io.ensa.green_morocco.repository.ProduitMatiereRepo;
import io.ensa.green_morocco.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    @Autowired
    private ICooperativeService cooperativeService;

    @Autowired
    private IMatierePService matierePService;

    @Autowired
    private ProduitMatiereRepo produitMatiereRepo;

    @Override
    @Transactional
    public ProduitResponseDTo addProduit(ProduitRequestDTo produitRequestDTo, MatiereP... matierePS) {
        Produit produit = new Produit();

        produit.setNom(produitRequestDTo.getNom());
        produit.setPrix(produitRequestDTo.getPrix());
        produit.setQuantite(produitRequestDTo.getQuantite());

        Cooperative cooperative = cooperativeService.getCooperative(produitRequestDTo.getCooperativeId());
        produit.setCoop(cooperative);

        for(MatiereP matiereP : matierePS){
            MatiereP m = matierePService.getMatiereP(matiereP.getId());
            produit.addMatiere(m);
        }

        Produit savedProduit = produitRepo.save(produit);
        cooperative.addProduit(savedProduit);

//        for(MatiereP matiereP : matierePS){
//            MatiereP m = matierePService.getMatiereP(matiereP.getId());
//            m.addProduit(savedProduit);
//        }

        return Mapper.produitToProduitResponseDTo(savedProduit);
    }

    @Override
    public ProduitResponseDTo getProduitById(Long produitId) {
        return Mapper.produitToProduitResponseDTo(getProduit(produitId));
    }

    @Override
    public Produit getProduit(Long produitId) {
        return produitRepo.findById(produitId).orElseThrow(()->new IllegalArgumentException("Produit with id " + produitId + " not found"));
    }

    @Override
    public List<ProduitResponseDTo> getProduits() {
        return Mapper.produitToProduitResponseDTo(produitRepo.findAll());
    }

    @Override
    public List<ProduitResponseDTo> getProduitsByCooperative(Long idCooperative) {
        return Mapper.produitToProduitResponseDTo(cooperativeService.getCooperative(idCooperative).getProduits());
    }

    @Override
    public List<ProduitResponseDTo> getProduitsByMatiereP(Long idMatiereP) {
//        return Mapper.produitToProduitResponseDTo(matierePService.getMatiereP(idMatiereP).getProduits());
        return null;
    }

    @Override
    @Transactional
    public ProduitResponseDTo deleteProduit(Long produitId) {
        Produit produit = getProduit(produitId);
//        List<MatiereP> matierePS = produit.getMatierePS();
//        for (MatiereP matiereP : matierePS){
//            produit.removeMatiere(matiereP);
//            matiereP.removeProduit(produit);
//        }
        produitRepo.deleteById(produit.getId());
        return Mapper.produitToProduitResponseDTo(produit);
    }

    @Override
    public ProduitResponseDTo editProduit(Long produitId, ProduitRequestDTo produitRequestDTo) {
        return null;
    }

    @Override
    public ProduitResponseDTo addMatierePToProduit(Long produitId, Long MatierePId) {
        return null;
    }

    @Override
    public ProduitResponseDTo removeMatierePFromProduit(Long produitId, Long matierePId) {
        return null;
    }
}
