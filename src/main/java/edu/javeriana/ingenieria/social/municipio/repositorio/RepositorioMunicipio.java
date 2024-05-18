package edu.javeriana.ingenieria.social.municipio.repositorio;

import edu.javeriana.ingenieria.social.municipio.dominio.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMunicipio extends JpaRepository<Municipio, Integer> {
    Municipio findOneByCodigoPostal(Integer codigoPostal);

    List<Municipio> findAllByDepartamento(String departamento);

    boolean existsByCodigoPostal(Integer codigoPostal);
}
