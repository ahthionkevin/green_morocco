package io.ensa.green_morocco.controller;

import io.ensa.green_morocco.DTo.Request.CooperativeRequestDTo;
import io.ensa.green_morocco.DTo.Request.RegionRequestDTo;
import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.service.ICooperativeService;
import io.ensa.green_morocco.service.IOrigineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/cooperative")
public class CooperativeController {

    @Autowired
    private ICooperativeService cooperativeService;

    @GetMapping(path = "/{id}")
    protected ResponseEntity<?> getCooperative(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok().body(cooperativeService.getCooperativeById(id));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping(path = "")
    protected ResponseEntity<List<CooperativeResponseDTo>> getAllCooperative(){
        return ResponseEntity.ok().body(cooperativeService.getCooperatives());
    }

    @PostMapping("/register")
    protected ResponseEntity<?> registerCooperative(@RequestBody CooperativeRequestDTo cooperativeRequestDTo){
        try{
            return ResponseEntity.created(null).body(cooperativeService.addCooperative(cooperativeRequestDTo));
        }catch (Exception e){
            Map<String,String> error = new HashMap<>();
            error.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping(path = "/edit/{id}")
    protected ResponseEntity<CooperativeResponseDTo> editCooperative(@PathVariable(name = "id",required = true) Long id, @RequestBody CooperativeRequestDTo cooperativeRequestDTo){
        return ResponseEntity.ok().body(cooperativeService.editCooperative(id,cooperativeRequestDTo));
    }
}
