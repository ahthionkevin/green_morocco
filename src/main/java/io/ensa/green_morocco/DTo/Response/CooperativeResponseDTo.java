package io.ensa.green_morocco.DTo.Response;

import io.ensa.green_morocco.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class CooperativeResponseDTo {
    private Long id;

    private String nom;

    private String tel;

    private Long regionId;

    List<Long> produitId;

}
