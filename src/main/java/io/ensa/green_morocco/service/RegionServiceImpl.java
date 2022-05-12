package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.RegionRequestDTo;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionRepo regionRepo;

    @Override
    public Region addRegion(RegionRequestDTo regionRequestDTo) {
        Region region = new Region();
        region.setNom(regionRequestDTo.getName());
        return regionRepo.save(region);
    }

    @Override
    public Region getRegion(Long regionId) {
        return regionRepo.findById(regionId).orElseThrow(()->new IllegalArgumentException("Region with id " + regionId + " not found"));
    }

    @Override
    public List<Region> getRegions() {
        return regionRepo.findAll();
    }

    @Override
    public Region deleteRegion(Long regionId) {
        Region region = getRegion(regionId);
        regionRepo.deleteById(region.getId());
        return region;
    }

    @Override
    @Transactional
    public Region editRegion(Long regionId, RegionRequestDTo regionRequestDTo) {
        Region regionToEdit = getRegion(regionId);
        if(regionRequestDTo.getName()!=null)
            regionToEdit.setNom(regionRequestDTo.getName());
        return regionToEdit;
    }
}
