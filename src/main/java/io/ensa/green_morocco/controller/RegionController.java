package io.ensa.green_morocco.controller;

import io.ensa.green_morocco.DTo.Request.OrigineRequestDTo;
import io.ensa.green_morocco.DTo.Request.RegionRequestDTo;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.service.IOrigineService;
import io.ensa.green_morocco.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/region")
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @GetMapping(path = "/{id}")
    protected ResponseEntity<?> getRegion(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok().body(regionService.getRegion(id));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping(path = "")
    protected ResponseEntity<List<Region>> getAllRegion(){
        return ResponseEntity.ok().body(regionService.getRegions());
    }

    @PostMapping(path = "/save")
    protected ResponseEntity<Region> createMatiereP(@RequestBody RegionRequestDTo regionRequestDTo){
        return ResponseEntity.created(null).body(regionService.addRegion(regionRequestDTo));
    }

    @PutMapping(path = "/edit/{id}")
    protected ResponseEntity<Region> editMatiereP(@PathVariable(name = "id",required = true) Long id,@RequestBody RegionRequestDTo regionRequestDTo){
        return ResponseEntity.ok().body(regionService.editRegion(id,regionRequestDTo));
    }
}
