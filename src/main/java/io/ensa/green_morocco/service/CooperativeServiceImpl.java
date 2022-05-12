package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Mapper;
import io.ensa.green_morocco.DTo.Request.CooperativeRequestDTo;
import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.entity.Cooperative;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.repository.CooperativeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CooperativeServiceImpl implements ICooperativeService {

    @Autowired
    private CooperativeRepo cooperativeRepo;

    @Autowired
    private IRegionService regionService;



    @Override
    @Transactional
    public CooperativeResponseDTo addCooperative(CooperativeRequestDTo cooperativeRequestDTo) {
        Cooperative cooperative = new Cooperative();
        cooperative.setNom(cooperativeRequestDTo.getNom());
        cooperative.setTel(cooperativeRequestDTo.getTel());

        Region region = regionService.getRegion(cooperativeRequestDTo.getRegionId());
        cooperative.setRegion(region);
        Cooperative savedCooperative = cooperativeRepo.save(cooperative);
        region.addCoop(savedCooperative);

        return Mapper.cooperativeToCooperativeResponseDTo(savedCooperative);
    }

    @Override
    public List<CooperativeResponseDTo> getCooperatives() {
        return Mapper.cooperativeToCooperativeResponseDTo(cooperativeRepo.findAll());
    }

    @Override
    public CooperativeResponseDTo getCooperativeById(Long cooperativeId) {
        Cooperative cooperative = getCooperative(cooperativeId);
        return Mapper.cooperativeToCooperativeResponseDTo(cooperative);
    }

    @Override
    public Cooperative getCooperative(Long cooperativeId) {
        return cooperativeRepo.findById(cooperativeId).orElseThrow(()->new IllegalArgumentException("cooperative with id " + cooperativeId + " not found"));
    }

    @Override
    @Transactional
    public CooperativeResponseDTo deleteCooperative(Long cooperativeId) {
        Cooperative cooperative = getCooperative(cooperativeId);
        cooperativeRepo.deleteById(cooperative.getId());
        return Mapper.cooperativeToCooperativeResponseDTo(cooperative);
    }

    @Override
    @Transactional
    public CooperativeResponseDTo editCooperative(Long cooperativeId, CooperativeRequestDTo cooperativeRequestDTo) {

        Cooperative cooperativeToEdit = getCooperative(cooperativeId);
        cooperativeToEdit.setNom(cooperativeRequestDTo.getNom());
        cooperativeToEdit.setTel(cooperativeRequestDTo.getTel());
        return Mapper.cooperativeToCooperativeResponseDTo(cooperativeToEdit);
    }

}
