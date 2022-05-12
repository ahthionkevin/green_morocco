package io.ensa.green_morocco.controller;

import io.ensa.green_morocco.DTo.Request.MatierePRequestDTo;
import io.ensa.green_morocco.DTo.Request.OrigineRequestDTo;
import io.ensa.green_morocco.DTo.Request.RegionRequestDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.service.IOrigineService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/origine")
public class OrigineController {

    @Autowired
    private IOrigineService origineService;

    @GetMapping(path = "/{id}")
    protected ResponseEntity<?> getOrigne(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok().body(origineService.getOrigine(id));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping(path = "")
    protected ResponseEntity<List<Origine>> getAllOrigine(){
        return ResponseEntity.ok().body(origineService.getOrigines());
    }

    @PostMapping(path = "/save")
    protected ResponseEntity<Origine> createMatiereP(@RequestBody OrigineRequestDTo origineRequestDTo){
        return ResponseEntity.created(null).body(origineService.addOrigine(origineRequestDTo));
    }

    @PutMapping(path = "/edit/{id}")
    protected ResponseEntity<Origine> editMatiereP(@PathVariable(name = "id",required = true) Long id, @RequestBody OrigineRequestDTo origineRequestDTo){
        return ResponseEntity.ok().body(origineService.editOrigine(id,origineRequestDTo));
    }
}
