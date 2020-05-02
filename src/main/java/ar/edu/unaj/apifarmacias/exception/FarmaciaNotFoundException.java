package ar.edu.unaj.apifarmacias.exception;

public class FarmaciaNotFoundException extends RuntimeException {

    public FarmaciaNotFoundException(Long id) {
        super("Farmacia id not found: " + id);
    }
}
