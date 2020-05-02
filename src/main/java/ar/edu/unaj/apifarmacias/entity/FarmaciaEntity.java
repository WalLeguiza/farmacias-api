package ar.edu.unaj.apifarmacias.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "farmacias")
@Data
public class FarmaciaEntity {

    @Id
    private String id;
    private String direccion;
    private String barrio;
    private int comuna;

}
