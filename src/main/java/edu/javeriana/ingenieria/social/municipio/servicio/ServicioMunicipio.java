package edu.javeriana.ingenieria.social.municipio.servicio;

import edu.javeriana.ingenieria.social.municipio.dominio.Municipio;
import edu.javeriana.ingenieria.social.municipio.repositorio.RepositorioMunicipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMunicipio {
    @Autowired
    private RepositorioMunicipio repositorio;

    public List<Municipio> obtenerMunicipios(){
        return repositorio.findAll();
    }

    public List<Municipio> obtenerMunicipios(String departamento){
        return repositorio.findAllByDepartamento(departamento);
    }

    public Municipio obtenerMunicipio(Integer codigoPostal){
        return repositorio.findOneByCodigoPostal(codigoPostal);
    }

    public boolean municipioExiste(Integer codigoPostal){
        return repositorio.existsByCodigoPostal(codigoPostal);
    }

}
