package io.ensa.green_morocco.DTo.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatierePRequestDTo {
    private String name;
    private Long origineId;
}
