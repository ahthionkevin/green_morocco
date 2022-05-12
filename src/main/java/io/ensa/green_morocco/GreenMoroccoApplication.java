package io.ensa.green_morocco;

import io.ensa.green_morocco.DTo.Request.*;
import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.DTo.Response.MatierePResponseDTo;
import io.ensa.green_morocco.entity.MatiereP;
import io.ensa.green_morocco.entity.Origine;
import io.ensa.green_morocco.entity.Region;
import io.ensa.green_morocco.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GreenMoroccoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenMoroccoApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(
            ICooperativeService cooperativeService,
            IRegionService regionService,
            IMatierePService matierePService,
            IOrigineService origineService,
            IProduitService produitService
    ){
        return args -> {
            //Adding new Origine
            Origine o1 = origineService.addOrigine(new OrigineRequestDTo("Agadir"));
            Origine o2 = origineService.addOrigine(new OrigineRequestDTo("Tanger"));
            Origine o3 = origineService.addOrigine(new OrigineRequestDTo("Tiznit"));

            //Adding new region
            Region r1 = regionService.addRegion(new RegionRequestDTo("casablanca"));
            Region r2 = regionService.addRegion(new RegionRequestDTo("Rabat"));
            Region r3 = regionService.addRegion(new RegionRequestDTo("Tetouan"));

            System.out.println(r3);

            //Adding Cooperative
            CooperativeResponseDTo c1 = cooperativeService.addCooperative(new CooperativeRequestDTo("CTM","07000000000","CTM",r1.getId()));
            CooperativeResponseDTo c2 = cooperativeService.addCooperative(new CooperativeRequestDTo("STCR","07000000000","STCR",r2.getId()));
            CooperativeResponseDTo c3 = cooperativeService.addCooperative(new CooperativeRequestDTo("BAbSalam","07000000000","BAbSalam",r3.getId()));


            //Adding Matiere Premiere
            MatierePResponseDTo m1 = matierePService.addMatiereP(new MatierePRequestDTo("Miel",o1.getId()));
            MatierePResponseDTo m2 = matierePService.addMatiereP(new MatierePRequestDTo("Amlou", o3.getId()));

            MatiereP matiere1 = matierePService.getMatiereP(m1.getId());
            MatiereP matiere2 = matierePService.getMatiereP(m2.getId());

            //Adding Produit
            produitService.addProduit(new ProduitRequestDTo("Miel du Souss",12,140.50f, c1.getId()),matiere1);
            produitService.addProduit(new ProduitRequestDTo("Bonbon de Midalt",200,14.50f, c1.getId()),matiere1,matiere2);
            produitService.addProduit(new ProduitRequestDTo("Miel d'Atlas",12,140.50f, c2.getId()),matiere2);

            //Deleting Cooperative
//            cooperativeService.deleteCooperative(1L);

            //Deleting Region
//            regionService.deleteRegion(r3.getId());

            //Deleting Origine
//            origineService.deleteOrigine(o1.getId());

//            Deleting Produit
//            produitService.deleteProduit(1L);

            //Deleting Matiere Premiere
            matierePService.deleteMatiereP(1L);
        };
    }

}
