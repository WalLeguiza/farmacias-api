package ar.edu.unaj.apifarmacias.service;

import ar.edu.unaj.apifarmacias.dto.CantidadPorComunaBarrioDto;
import ar.edu.unaj.apifarmacias.dto.CantidadPorComunaDto;
import ar.edu.unaj.apifarmacias.entity.FarmaciaEntity;
import ar.edu.unaj.apifarmacias.repository.FarmaciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public List<FarmaciaEntity> getAllFarmacias () {
        return farmaciaRepository.findAll();
    }

    public List<FarmaciaEntity> getAllFarmaciasByComuna (int comuna) {
        return farmaciaRepository.findAllByComuna(comuna);
    }

    public List<CantidadPorComunaDto> getAllCantidadFarmaciasByComuna () {

        List<CantidadPorComunaDto> dtos = new ArrayList<>();
        List<Integer> comunas = farmaciaRepository.findAll().stream().map(FarmaciaEntity::getComuna).distinct().collect(toList());

        for ( int c : comunas) {
            List<FarmaciaEntity> farmacias = farmaciaRepository.findAllByComuna(c);
            dtos.add(CantidadPorComunaDto.builder().nroComuna(c).cantidadFarmacias(farmacias.size()).build());
        }

        return dtos;
    }

    public List<CantidadPorComunaBarrioDto> getAllCantidadFarmaciasByComunaAndBarrio () {

        List<CantidadPorComunaBarrioDto> dtos = new ArrayList<>();
        List<Integer> comunas = farmaciaRepository.findAll().stream().map(FarmaciaEntity::getComuna).distinct().collect(toList());
        List<String> barrios = farmaciaRepository.findAll().stream().map(FarmaciaEntity::getBarrio).distinct().collect(toList());

        for ( int c : comunas) {
            for (String b : barrios) {
                List<FarmaciaEntity> farmacias = farmaciaRepository.findAllByBarrioAndComuna(b, c);
                if (!farmacias.isEmpty()) {
                    dtos.add(CantidadPorComunaBarrioDto.builder().nroComuna(c).barrio(b).cantidadFarmacias(farmacias.size()).build());
                }
            }
        }

        return dtos;
    }
}
