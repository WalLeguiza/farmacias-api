package ar.edu.unaj.apifarmacias.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CantidadPorComunaBarrioDto {

    private int nroComuna;
    private String barrio;
    private int cantidadFarmacias;
}
