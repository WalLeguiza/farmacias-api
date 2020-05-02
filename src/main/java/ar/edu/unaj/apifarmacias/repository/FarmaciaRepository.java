package ar.edu.unaj.apifarmacias.repository;

import ar.edu.unaj.apifarmacias.entity.FarmaciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmaciaRepository extends MongoRepository<FarmaciaEntity, String> {

    List<FarmaciaEntity> findAllByComuna (int comuna);

    List<FarmaciaEntity> findAllByBarrioAndComuna (String barrio, int comuna);
}
