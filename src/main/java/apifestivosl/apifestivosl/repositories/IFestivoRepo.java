package apifestivosl.apifestivosl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivosl.apifestivosl.entities.Festivo;

@Repository
public interface IFestivoRepo extends JpaRepository<Festivo, Integer> {

}
