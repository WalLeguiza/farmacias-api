package ar.edu.unaj.apifarmacias.controller;

import ar.edu.unaj.apifarmacias.dto.CantidadPorComunaBarrioDto;
import ar.edu.unaj.apifarmacias.dto.CantidadPorComunaDto;
import ar.edu.unaj.apifarmacias.entity.FarmaciaEntity;
import ar.edu.unaj.apifarmacias.repository.FarmaciaRepository;
import ar.edu.unaj.apifarmacias.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farmacias")
@CrossOrigin(origins = "*")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FarmaciaEntity>> getAll () {
        return new ResponseEntity(farmaciaService.getAllFarmacias(), HttpStatus.OK);
    }

    @GetMapping(value = "/comuna/{comuna}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FarmaciaEntity>> getAll (@PathVariable("comuna") int comuna) {
        return new ResponseEntity(farmaciaService.getAllFarmaciasByComuna(comuna), HttpStatus.OK);
    }

    @GetMapping(value = "/cantidadByComuna", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CantidadPorComunaDto>> getCantidadFarmaciasByComuna () {
        return new ResponseEntity<>(farmaciaService.getAllCantidadFarmaciasByComuna(), HttpStatus.OK);
    }

    @GetMapping(value = "/cantidadByComunaBarrio", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CantidadPorComunaBarrioDto>> getCantidadFarmaciasByComunaBarrio () {
        return new ResponseEntity<>(farmaciaService.getAllCantidadFarmaciasByComunaAndBarrio(), HttpStatus.OK);
    }

    @GetMapping(value = "/comunaAndBarrio", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FarmaciaEntity>> getCantidadFarmaciasByComunaAndBarrio (@RequestParam("comuna") int comuna, @RequestParam("barrio") String barrio) {
        return new ResponseEntity<>(farmaciaRepository.findAllByBarrioAndComuna(barrio, comuna), HttpStatus.OK);
    }

}
