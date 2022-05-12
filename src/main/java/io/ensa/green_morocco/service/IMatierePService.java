package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.MatierePRequestDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.entity.MatiereP;

import java.util.List;

public interface IMatierePService {
    MatierePResponseDTo addMatiereP(MatierePRequestDTo matierePRequestDTo);
    MatierePResponseDTo getMatierePBtyId(Long matierePId);
    MatiereP getMatiereP(Long matierePId);
    List<MatierePResponseDTo> getMatierePBtyId();
    MatierePResponseDTo deleteMatiereP(Long matierePId);
    MatierePResponseDTo editMatiereP(Long matierePId,MatierePRequestDTo matierePRequestDTo);
}
