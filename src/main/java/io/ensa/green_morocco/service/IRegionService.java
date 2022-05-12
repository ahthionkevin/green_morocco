package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.RegionRequestDTo;
import io.ensa.green_morocco.entity.Region;

import java.util.List;

public interface IRegionService {
    Region addRegion(RegionRequestDTo regionRequestDTo);
    Region getRegion(Long regionId);
    List<Region> getRegions();
    Region deleteRegion(Long regionId);
    Region editRegion(Long regionId,RegionRequestDTo regionRequestDTo);
}
