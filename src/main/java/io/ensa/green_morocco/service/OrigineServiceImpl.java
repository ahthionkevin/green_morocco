package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.OrigineRequestDTo;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.repository.OrigineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrigineServiceImpl implements IOrigineService {

    @Autowired
    private OrigineRepo origineRepo;

    @Override
    public Origine addOrigine(OrigineRequestDTo origineRequestDTo) {
        Origine origine = new Origine();
        origine.setNom(origineRequestDTo.getName());
        return origineRepo.save(origine);
    }

    @Override
    public Origine getOrigine(Long origineId) {
        return origineRepo.findById(origineId).orElseThrow(()->new IllegalArgumentException("Origine with id " + origineId + " not found"));
    }

    @Override
    public List<Origine> getOrigines() {
        return origineRepo.findAll();
    }

    @Override
    @Transactional
    public Origine deleteOrigine(Long origineId) {
        Origine origine = getOrigine(origineId);
        origineRepo.deleteById(origine.getId());
        return origine;
    }

    @Override
    @Transactional
    public Origine editOrigine(Long origineId, OrigineRequestDTo origineRequestDTo) {
        Origine origineToEdit = getOrigine(origineId);
        if(origineRequestDTo.getName()!=null)
            origineToEdit.setNom(origineRequestDTo.getName());
        return origineToEdit;
    }
}
