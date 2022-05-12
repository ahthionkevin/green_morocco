package io.ensa.green_morocco.DTo.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CooperativeRequestDTo {
    private String nom;
    private String tel;
    private String password;
    private Long regionId;
}
