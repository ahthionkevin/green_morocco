package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Mapper;
import io.ensa.green_morocco.DTo.Request.MatierePRequestDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.entity.MatiereP;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.repository.MatierePRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MatierePServiceImpl implements IMatierePService {

    @Autowired
    private MatierePRepo matierePRepo;

    @Autowired
    private IOrigineService origineService;

    @Override
    @Transactional
    public MatierePResponseDTo addMatiereP(MatierePRequestDTo matierePRequestDTo) {
        MatiereP matiereP = new MatiereP();
        matiereP.setNom(matierePRequestDTo.getName());

        if(matierePRequestDTo.getOrigineId()==null)
            throw new IllegalArgumentException("Matiere Premiere must always have origine");

        Origine origine = origineService.getOrigine(matierePRequestDTo.getOrigineId());
        matiereP.setOrigine(origine);

        MatiereP savedMatiereP = matierePRepo.save(matiereP);
        origine.addMatiereP(savedMatiereP);

        return Mapper.matiereToMatierePResponseDTo(savedMatiereP);
    }

    @Override
    public MatierePResponseDTo getMatierePBtyId(Long matierePId) {
        return Mapper.matiereToMatierePResponseDTo(getMatiereP(matierePId));
    }

    @Override
    public MatiereP getMatiereP(Long matierePId) {
        return matierePRepo.findById(matierePId).orElseThrow(() -> new IllegalArgumentException("Matiere Premiere with id " + matierePId + " not found"));
    }

    @Override
    public List<MatierePResponseDTo> getMatierePBtyId() {
        return Mapper.matiereToMatierePResponseDTo(matierePRepo.findAll());
    }

    @Override
    public MatierePResponseDTo deleteMatiereP(Long matierePId) {
        MatiereP matiereP = getMatiereP(matierePId);
        matierePRepo.deleteById(matiereP.getId());
        return Mapper.matiereToMatierePResponseDTo(matiereP);
    }

    @Override
    @Transactional
    public MatierePResponseDTo editMatiereP(Long matierePId, MatierePRequestDTo matierePRequestDTo) {
        MatiereP matiereP = getMatiereP(matierePId);
        matiereP.setNom(matierePRequestDTo.getName());

        if(matierePRequestDTo.getOrigineId()==null)
            throw new IllegalArgumentException("Matiere Premiere must always have origine");

        Origine origine = origineService.getOrigine(matierePRequestDTo.getOrigineId());
        matiereP.setOrigine(origine);

        return Mapper.matiereToMatierePResponseDTo(matiereP);
    }
}
