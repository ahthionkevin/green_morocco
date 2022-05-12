package io.ensa.green_morocco.controller;

import io.ensa.green_morocco.DTo.Request.MatierePRequestDTo;
import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.service.ICooperativeService;
import io.ensa.green_morocco.service.IMatierePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matiere")
public class MatierePController {
    @Autowired
    private IMatierePService matierePService;

    @GetMapping(path = "/{id}")
    protected ResponseEntity<?> getMatiere(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok().body(matierePService.getMatierePBtyId(id));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping(path = "")
    protected ResponseEntity<List<MatierePResponseDTo>> getAllMatiereP(){
        return ResponseEntity.ok().body(matierePService.getMatierePBtyId());
    }

    @PostMapping(path = "/save")
    protected ResponseEntity<MatierePResponseDTo> createMatiereP(@RequestBody MatierePRequestDTo matierePRequestDTo){
        return ResponseEntity.created(null).body(matierePService.addMatiereP(matierePRequestDTo));
    }
}
