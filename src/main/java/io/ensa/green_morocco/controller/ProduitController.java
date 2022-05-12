package io.ensa.green_morocco.controller;

import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.DTo.Response.ProduitResponseDTo;
import io.ensa.green_morocco.service.ICooperativeService;
import io.ensa.green_morocco.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
    private IProduitService produitService;

    @GetMapping(path = "/{id}")
    protected ResponseEntity<?> getProduit(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok().body(produitService.getProduitById(id));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping(path = "")
    protected ResponseEntity<List<ProduitResponseDTo>> getAllProduit(){
        return ResponseEntity.ok().body(produitService.getProduits());
    }

    @GetMapping(params = {"id_coop"})
    protected ResponseEntity<List<ProduitResponseDTo>> getAllProduitByCooperative(@RequestParam(name = "id_coop") Long idCoop){
        return ResponseEntity.ok().body(produitService.getProduitsByCooperative(idCoop));
    }

    @GetMapping(params = {"id_mp"})
    protected ResponseEntity<List<ProduitResponseDTo>> getAllProduitByMP(@RequestParam(name = "id_mp") Long idMP){
        return ResponseEntity.ok().body(produitService.getProduitsByMatiereP(idMP));
    }
}
