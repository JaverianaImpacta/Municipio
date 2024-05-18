package edu.javeriana.ingenieria.social.municipio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Municipio {
    @Id
    private Integer id;
    private String nombre, departamento;
    @Column(name="codigo_postal")
    private Integer codigoPostal;
}
