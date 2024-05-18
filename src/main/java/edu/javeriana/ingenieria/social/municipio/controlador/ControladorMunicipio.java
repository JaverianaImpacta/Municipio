package edu.javeriana.ingenieria.social.municipio.controlador;

import edu.javeriana.ingenieria.social.municipio.dominio.Municipio;
import edu.javeriana.ingenieria.social.municipio.servicio.ServicioMunicipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorMunicipio {
    @Autowired
    private ServicioMunicipio servicio;

    @GetMapping("listar")
    public List<Municipio> obtenerMunicpios(){
        return servicio.obtenerMunicipios();
    }

    @GetMapping("obtener")
    public ResponseEntity<Municipio> obtenerMunicipio(@RequestParam Integer codigoPostal){
        if(codigoPostal==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.municipioExiste(codigoPostal)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMunicipio(codigoPostal), HttpStatus.OK);
    }

    @GetMapping("obtenerDepartamento")
    public ResponseEntity<List<Municipio>> obtenerMunicipios(@RequestParam String departamento){
        if(departamento==null || departamento.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerMunicipios(departamento).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMunicipios(departamento), HttpStatus.OK);
    }
}
