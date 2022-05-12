package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.OrigineRequestDTo;
import io.ensa.green_morocco.entity.Origine;

import java.util.List;

public interface IOrigineService {
    Origine addOrigine(OrigineRequestDTo origineRequestDTo);
    Origine getOrigine(Long origineId);
    List<Origine> getOrigines();
    Origine deleteOrigine(Long regionId);
    Origine editOrigine(Long origineId,OrigineRequestDTo origineRequestDTo);
}
